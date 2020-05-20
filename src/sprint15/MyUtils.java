package sprint15;

import java.sql.*;
import java.util.*;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName = "soft_serve";

    public static void main(String[] args) throws SQLException {
        MyUtils myUtils = new MyUtils();

        String userName = "dbadmin";
        String url = "jdbc:mysql://localhost:3306/soft_serve?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        String password = "Theaternimda1";
        myUtils.connection = DriverManager.getConnection(url, userName, password);
        myUtils.statement = myUtils.connection.createStatement();

        System.out.println(myUtils.getAllJavaDevelopers());
        myUtils.closeConnection();

    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        return statement = connection.createStatement();
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        statement = createStatement();
        this.schemaName = schemaName;
        String sql = "CREATE SCHEMA " + this.schemaName;
        statement.executeUpdate(sql);
    }

    public void dropSchema() throws SQLException {
        statement.executeUpdate("DROP SCHEMA " + this.schemaName);

    }

    public void useSchema() throws SQLException {
        statement.executeUpdate("USE " + schemaName);
    }

    public void createTableRoles() throws SQLException {
        statement.execute("CREATE TABLE Roles ("
                + " id INT NOT NULL AUTO_INCREMENT,"
                + " roleName VARCHAR(20) NOT NULL,"
                + " PRIMARY KEY(`id`),"
                + " UNIQUE INDEX id_ROLES(`id` ASC));");
    }

    public void createTableDirections() throws SQLException {
        statement.execute("CREATE TABLE Directions ("
                + " id INT NOT NULL AUTO_INCREMENT,"
                + " directionName VARCHAR(20) NOT NULL,"
                + " PRIMARY KEY(`id`),"
                + " UNIQUE INDEX id_DIRECTIONS(`id` ASC));");
    }

    public void createTableProjects() throws SQLException {
        statement.executeUpdate("CREATE TABLE projects (id INTEGER NOT NULL AUTO_INCREMENT " +
                "PRIMARY KEY, projectName varchar(255), directionId INTEGER, FOREIGN KEY (directionId) REFERENCES Directions(id) ON DELETE CASCADE)");
    }

    public void createTableEmployee() throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE employee (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, firstName varchar(255), " +
                        "roleId INTEGER, projectId INTEGER, " +
                        "FOREIGN KEY (roleId) REFERENCES Roles(id) ON DELETE CASCADE, " +
                        "FOREIGN KEY (projectId) REFERENCES Projects(id) ON DELETE CASCADE)");
    }

    public void dropTable(String tableName) throws SQLException {
        createStatement().executeUpdate("DROP TABLE IF EXISTS " + tableName);
    }

    public void insertTableRoles(String roleName) throws SQLException {
        statement.executeUpdate("INSERT INTO roles (roleName) VALUES ('" + roleName + "');");

    }

    public void insertTableDirections(String directionName) throws SQLException {
        statement.executeUpdate("INSERT INTO directions (directionName) VALUES ('" + directionName + "');");
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        String sql = "SELECT id FROM DIRECTIONS WHERE directionName='" + directionName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        int directionId = 0;
        if (resultSet.next()) {
            directionId = resultSet.getInt("id");
        }
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO projects (projectName, directionId) VALUES (?, ?)");
        preparedStatement.setString(1, projectName);
        preparedStatement.setInt(2, directionId);
        preparedStatement.execute();
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        String sqlToGetRoleId = "SELECT id FROM ROLES WHERE roleName='" + roleName + "'";
        ResultSet resultSetForRoleId = statement.executeQuery(sqlToGetRoleId);
        int roleId = 0;
        if (resultSetForRoleId.next()) {
            roleId = resultSetForRoleId.getInt("id");
        }

        String sqlToGetProjectsId = "SELECT id FROM PROJECTS WHERE projectName='" + projectName + "'";
        ResultSet resultSetForProjectId = statement.executeQuery(sqlToGetProjectsId);
        int projectId = 0;
        if (resultSetForProjectId.next()) {
            projectId = resultSetForProjectId.getInt("id");
        }

        java.sql.PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (firstName, roleId, projectId)" +
                " VALUES (?, ?, ?)");

        preparedStatement.setString(1, firstName);
        preparedStatement.setInt(2, roleId);
        preparedStatement.setInt(3, projectId);

        preparedStatement.execute();
    }

    public int getRoleId(String roleName) throws SQLException {
        String sql = "SELECT id FROM ROLES WHERE rolename='" + roleName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        int roleId = 0;
        if (resultSet.next()) {
            roleId = resultSet.getInt("id");
        }
        return roleId;
    }

    public int getDirectionId(String directionName) throws SQLException {
        String sql = "SELECT id FROM DIRECTIONS WHERE directionName='" + directionName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        int directionId = 0;
        if (resultSet.next()) {
            directionId = resultSet.getInt("id");
        }
        return directionId;
    }

    public int getProjectId(String projectName) throws SQLException {
        String sql = "SELECT id FROM PROJECTS WHERE projectName='" + projectName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        int projectId = 0;
        if (resultSet.next()) {
            projectId = resultSet.getInt("id");
        }
        return projectId;
    }

    public int getEmployeeId(String firstName) throws SQLException {
        String sql = "SELECT id FROM EMPLOYEE WHERE firstName='" + firstName + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        int employeeId = 0;
        if (resultSet.next()) {
            employeeId = resultSet.getInt("id");
        }
        return employeeId;
    }

    public List<String> getAllRoles() throws SQLException {
        List<String> allRoles = new ArrayList<>();
        String sql = "SELECT roleName FROM ROLES";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            allRoles.add(resultSet.getString("roleName"));
        }
        return allRoles;
    }

    public List<String> getAllDirestion() throws SQLException {
        List<String> allDirections = new ArrayList<>();
        String sql = "SELECT directionName FROM DIRECTIONS";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            allDirections.add(resultSet.getString("directionName"));
        }
        return allDirections;
    }

    public List<String> getAllProjects() throws SQLException {
        List<String> allProjects = new ArrayList<>();
        String sql = "SELECT projectName FROM PROJECTS";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            allProjects.add(resultSet.getString("projectName"));
        }
        return allProjects;
    }

    public List<String> getAllEmployee() throws SQLException {
        List<String> listOfEmployee = new ArrayList<>();
        String sql = "SELECT firstName FROM EMPLOYEE";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            listOfEmployee.add(resultSet.getString("firstName"));
        }
        return listOfEmployee;
    }

    public List<String> getAllDevelopers() throws SQLException {
        List<String> allDevelopers = new ArrayList<>();
        String sqlToGetDeveloperId = "SELECT id FROM ROLES WHERE roleName='Developer'";
        ResultSet resultSet = statement.executeQuery(sqlToGetDeveloperId);
        int developerId = 0;
        if(resultSet.next()){
            developerId = resultSet.getInt("id");
        }

        String sqlToGetDevelopersName = "SELECT firstName FROM EMPLOYEE WHERE roleId=" + developerId;
        ResultSet resultSet1 = statement.executeQuery(sqlToGetDevelopersName);

        while (resultSet1.next()){
            allDevelopers.add(resultSet1.getString("firstName"));
        }

        return allDevelopers;
    }

    public List<String> getAllJavaProjects() throws SQLException {
        List<String> allJavaProjects = new ArrayList<>();
        String sqlToGetDirectionId = "SELECT id FROM DIRECTIONS WHERE directionName='Java'";
        ResultSet resultSet = statement.executeQuery(sqlToGetDirectionId);
        int javaId = 0;
        if(resultSet.next()){
            javaId = resultSet.getInt("id");
        }

        String sqlToGetJavaProjects = "SELECT projectName FROM PROJECTS WHERE directionId=" + javaId;
        ResultSet resultSet1 = statement.executeQuery(sqlToGetJavaProjects);

        while (resultSet1.next()){
            allJavaProjects.add(resultSet1.getString("projectName"));
        }

        return allJavaProjects;
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        List<String> listOfJavaDeveloper = new ArrayList<>();
        String sql = "SELECT firstName FROM EMPLOYEE WHERE projectId IN (SELECT id FROM PROJECTS WHERE directionId=1) AND roleId=1;";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            listOfJavaDeveloper.add(resultSet.getString("firstName"));
        }
        return listOfJavaDeveloper;
    }

}


