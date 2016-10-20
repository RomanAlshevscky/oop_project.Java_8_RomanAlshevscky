package by.epam.training.velocity.command.impl;

import by.epam.training.velocity.bean.Request;
import by.epam.training.velocity.bean.Response;
import by.epam.training.velocity.bean.entity.CategoryReportEntity;
import by.epam.training.velocity.command.Command;
import by.epam.training.velocity.service.ReportService;
import by.epam.training.velocity.service.exception.ServiceException;
import by.epam.training.velocity.service.factory.ServiceFactory;

import java.util.LinkedList;
import java.util.List;

public class ReturnReport implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        ReportService service = factory.getReportService();

        Response response = new Response();
        try {

            List<CategoryReportEntity> reports = service.getReport();
            response.setErrorStatus(false);
            List<String> reportsLines = new LinkedList<>();

            for (CategoryReportEntity cre : reports){
                reportsLines.add(buildReportLine(cre));
            }

            response.setResponse(reportsLines);

        } catch (ServiceException e) {

            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());

        }

        return response;
    }

    private String buildReportLine(CategoryReportEntity report){
        StringBuilder sb = new StringBuilder();
        sb.append(report.getCategoryName()+" { ");
        sb.append("items count: "+report.getItemsCount()+", ");
        sb.append("max price: "+report.getMaxItemsPrice()+", ");
        sb.append("min price: "+report.getMinItemsPrice()+"; }\n");
        return sb.toString();
    }
}
