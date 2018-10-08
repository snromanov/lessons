package ru.stqa.pft.mantis.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.stqa.pft.mantis.models.Issue;
import ru.stqa.pft.mantis.models.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {

  private final ApplicationManager app;

  public   SoapHelper(ApplicationManager app) {
    this.app = app;

  }
  public Set<Project> getProjects() throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    ProjectData[] projects = mc.mc_projects_get_user_accessible(app.getAdminLogin(), app.getAdminPassword());
    return Arrays.asList(projects).stream()
            .map((p) -> new Project().setId(p.getId().intValue())
                    .setName(p.getName())).collect((Collectors.toSet()));
  }

  private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
    return new MantisConnectLocator()
            .getMantisConnectPort(new URL(app.getProperty("web.baseURL")+"/api/soap/mantisconnect.php"));
  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {
    MantisConnectPortType mc = getMantisConnect();
    String[] categories = mc.mc_project_get_categories(app.getAdminLogin(), app.getAdminPassword(), BigInteger.valueOf(issue.getProject().getId()));
    IssueData issueData = new IssueData();
    issueData.setSummary(issue.getSummary());
    issueData.setDescription(issue.getDescription());
    issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
    issueData.setCategory(categories[0]);
    BigInteger issueId = mc.mc_issue_add(app.getAdminLogin(), app.getAdminPassword(), issueData);
    IssueData createdIssueData = mc.mc_issue_get(app.getAdminLogin(), app.getAdminPassword(), issueId);
    return new Issue().setId(createdIssueData.getId().intValue())
            .setSummary(createdIssueData.getSummary())
            .setDescription(createdIssueData.getDescription())
            .setProject(new Project().setId(createdIssueData.getProject().getId().intValue())
                    .setName(createdIssueData.getProject().getName()));
  }
}