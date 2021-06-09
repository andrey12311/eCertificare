package model;


import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;


public class Datasource {

    public static final String DB_NAME = "Useri.db";
    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";


    public static final String COLUMN_QUESTION = "Question";


    public static final int COLUMN_QUESTION_INDEX = 1;
    public static final int COLUMN_WRONG_ANSWER_INDEX = 2;
    public static final int COLUMN_WRONG_ANSWER2_INDEX = 3;
    public static final int COLUMN_CORRECT_ANSWER_INDEX = 4;


    public static final int COLUMN_USERNAME_INDEX = 1;
    public static final int COLUMN_PASSWORD_INDEX = 2;
    public static final int COLUMN_FIRSTNAME_INDEX = 3;
    public static final int COLUMN_LASTNAME_INDEX = 4;
    public static final int COLUMN_SCHOOL_INDEX = 5;

    public static final String CHECK_FOR_LOGIN_QUERY = "SELECT * FROM " + TABLE_USERS + " WHERE ";


    URL resource = Datasource.class.getResource(DB_NAME);
    String cale;

    private boolean bazaDeDate() { //caut baza de date
        try {
            String path = new File(resource.toURI()).getAbsolutePath();
            this.cale = path;

            return true;
        } catch (URISyntaxException u) {

            u.printStackTrace();
            return false;
        }
    }

    private Connection connect() { //deschid baza de date
        Connection con = null;
        if (bazaDeDate()) {
            try {
                con = DriverManager.getConnection(String.format("jdbc:sqlite:%s", cale));
            } catch (SQLException e) {
                System.out.println("nu s-a putut deschide" + e.getMessage());
                e.printStackTrace();
            }
        }
        return con;
    }

    public boolean checkForUsername(String username) {
        if (username.equals("")) return false;
        Connection con = null;
        boolean usernameExists = false;
        try {
            con = connect();
            PreparedStatement st = con.prepareStatement("select Username from " + TABLE_USERS + " order by Username desc");
            ResultSet r1 = st.executeQuery();
            String usernameCounter;
            while (r1.next()) {

                usernameCounter = r1.getString(1);
                if (usernameCounter.equalsIgnoreCase(username)) {
                    usernameExists = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usernameExists;
    }

    public ArrayList<Examen> getQuestions(String tableName) {

        Connection con = null;
        String query = "Select * from " + tableName;
        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<Examen> exams = new ArrayList<>();

            while (resultSet.next()) {
                Examen examen = new Examen();
                examen.setQuestion(resultSet.getString(COLUMN_QUESTION_INDEX + 1));
                examen.setCorrAnswer(resultSet.getString(COLUMN_CORRECT_ANSWER_INDEX + 1));
                examen.setWrAnswer(resultSet.getString(COLUMN_WRONG_ANSWER_INDEX + 1));
                examen.setWrAnswer2(resultSet.getString(COLUMN_WRONG_ANSWER2_INDEX + 1));
                exams.add(examen);
            }
            return exams;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean checkLogin(String username, String password) {
        Connection con = null;
        StringBuilder sb = new StringBuilder(CHECK_FOR_LOGIN_QUERY);
        sb.append(COLUMN_PASSWORD);
        sb.append('=');
        sb.append("\"").append(password).append("\"").append(" AND ");
        sb.append(COLUMN_USERNAME);
        sb.append('=');
        sb.append("\"").append(username).append("\"");


        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString());
            if (resultSet.next()) return true;
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean register(String userName, String password,
                            String firstName, String lastName, String school) {
        Connection con = null;
        String query = "INSERT INTO Users (Username,Password,FirstName,LastName,School,BasicsL," +
                "OOPConceptsL,KeyWordsL) VALUES(?,?,?,?,?,?,?,?)";
        if (!checkForUsername(userName)) {

            try {
                con = connect();
                PreparedStatement statement = con.prepareStatement(query);

                statement.setString(COLUMN_USERNAME_INDEX, userName);
                statement.setString(COLUMN_PASSWORD_INDEX, password);
                statement.setString(COLUMN_FIRSTNAME_INDEX, firstName);
                statement.setString(COLUMN_LASTNAME_INDEX, lastName);
                statement.setString(COLUMN_SCHOOL_INDEX, school);
                statement.setInt(6,0);
                statement.setInt(7,0);
                statement.setInt(8,0);
                statement.executeUpdate();
                return true;

            } catch (SQLException e) {
                System.out.println("ceva nu a mers bine la register");
                System.out.println(query);
                e.printStackTrace();
                return false;
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else return false;
    }

    public User queryUsers(String username) {
        User u = new User();
        Connection con = null;
        String query = "SELECT * FROM  " + TABLE_USERS + " WHERE " +
                COLUMN_USERNAME + '=' + "\"" + username + "\"";
        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                u.setUsername(resultSet.getString(COLUMN_USERNAME_INDEX));
                u.setPassword(resultSet.getString(COLUMN_PASSWORD_INDEX));
                u.setFirstName(resultSet.getString(COLUMN_FIRSTNAME_INDEX));
                u.setLastName(resultSet.getString(COLUMN_LASTNAME_INDEX));
                u.setSchool(resultSet.getString(COLUMN_SCHOOL_INDEX));
            }
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public User updateUser(String oldUsername, String newUsername, String password, String firstName,
                           String lastName, String school, User u) {
        Connection con = null;
        String sql = "UPDATE " + TABLE_USERS + " SET Username=?,Password=?," +
                "FirstName=?,LastName=?,School=? WHERE Username =" + "\"" + oldUsername + "\"";
        String sql2 = "UPDATE History set Username=? WHERE Username="+"\"" + oldUsername + "\"";
        try {
            con = connect();
            PreparedStatement statement = con.prepareStatement(sql);
            PreparedStatement statement1 = con.prepareStatement(sql2);
            statement.setString(COLUMN_USERNAME_INDEX, newUsername);
            statement.setString(COLUMN_PASSWORD_INDEX, password);
            statement.setString(COLUMN_FIRSTNAME_INDEX, firstName);
            statement.setString(COLUMN_LASTNAME_INDEX, lastName);
            statement.setString(COLUMN_SCHOOL_INDEX, school);
            statement1.setString(1,newUsername);
            statement1.executeUpdate();
            statement.executeUpdate();
            u.setUsername(newUsername);
            u.setSchool(school);
            u.setFirstName(firstName);
            u.setLastName(lastName);
            u.setSchool(school);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;
    }

    public ArrayList<String> queryAllUsers() {
        Connection con = null;
        String query = "Select Username from Users ORDER BY Username ASC";
        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<String> username = new ArrayList<>();

            while (resultSet.next()) {
                username.add(resultSet.getString(1));
            }
            return username;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteUser(String username) {
        String sql = "DELETE FROM " + TABLE_USERS +
                " WHERE Username=?";
        Connection con = null;
        if (checkForUsername(username)) {
            try {
                con = connect();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(COLUMN_USERNAME_INDEX, username);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Examen> searchTest(String tableName, String word) {
        Connection con = null;
        String query = "Select * from " + tableName;
        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<Examen> exams = new ArrayList<>();
            ArrayList<Examen> exams2 = new ArrayList<>();

            while (resultSet.next()) {
                Examen examen = new Examen();
                examen.setQuestion(resultSet.getString(COLUMN_QUESTION_INDEX + 1));
                examen.setCorrAnswer(resultSet.getString(COLUMN_CORRECT_ANSWER_INDEX + 1));
                examen.setWrAnswer(resultSet.getString(COLUMN_WRONG_ANSWER_INDEX + 1));
                examen.setWrAnswer2(resultSet.getString(COLUMN_WRONG_ANSWER2_INDEX + 1));
                exams.add(examen);
            }
            for (Examen exam : exams) {
                if (exam.getQuestion().toLowerCase().contains(word)) {
                    exams2.add(exam);
                }
            }
            if (!exams2.isEmpty()) return exams2;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Examen queryQuestion(String question, String table) {
        Examen e;
        Connection con = null;
        String query = "SELECT * FROM  " + table + " WHERE " +
                COLUMN_QUESTION + '=' + "\"" + question + "\"";
        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                e = new Examen();
                e.setWrAnswer(resultSet.getString(COLUMN_WRONG_ANSWER_INDEX + 1));
                e.setCorrAnswer(resultSet.getString(COLUMN_CORRECT_ANSWER_INDEX + 1));
                e.setQuestion(resultSet.getString(COLUMN_QUESTION_INDEX + 1));
                e.setWrAnswer2(resultSet.getString(COLUMN_WRONG_ANSWER2_INDEX + 1));
                return e;
            }

        } catch (SQLException ee) {
            ee.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        }
        return null;
    }

    public boolean addQuestion(String question, String corrAnswer, String wrAnswer, String wrAnswer2, String table) {
        Connection con = null;
        String query = "INSERT INTO " + table + "(Question,WrAnswer,WrAnswer2,CorrAnswer) VALUES(?,?,?,?)";

        if (testExists(question, table)) return false;

        try {
            con = connect();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(COLUMN_QUESTION_INDEX, question);
            statement.setString(COLUMN_WRONG_ANSWER_INDEX, wrAnswer);
            statement.setString(COLUMN_WRONG_ANSWER2_INDEX, wrAnswer2);
            statement.setString(COLUMN_CORRECT_ANSWER_INDEX, corrAnswer);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateQuestion(String oldQuestion, String question, String corrAnswer, String wrAnswer, String wrAnswer2, String table) {
        Connection con = null;
        String query = "UPDATE " + table + " SET Question=?,WrAnswer=?,WrAnswer2=?,CorrAnswer=? WHERE " +
                "Question = " + '\"' + oldQuestion + '\"';


        try {
            con = connect();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(COLUMN_QUESTION_INDEX, question);
            statement.setString(COLUMN_WRONG_ANSWER_INDEX, wrAnswer);
            statement.setString(COLUMN_WRONG_ANSWER2_INDEX, wrAnswer2);
            statement.setString(COLUMN_CORRECT_ANSWER_INDEX, corrAnswer);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean testExists(String question, String table) {
        Connection con = null;
        String query = "SELECT QUESTION FROM " + table + " WHERE QUESTION = " +
                '\"' + question + '\"';

        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query);

            if (set.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void deleteQuestion(String question, String table) {
        Connection con = null;
        String query = "DELETE FROM " + table + " WHERE " +
                COLUMN_QUESTION + "=?";

        try {
            con = connect();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, question);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkLessons(String username, String lesson) {
        Connection con = null;
        StringBuilder sb = new StringBuilder("Select ");

        switch (lesson) {
            case "Basics":
                sb.append("BasicsL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Keywords":
                sb.append("KeyWordsL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "OopConcepts":
                sb.append("OOPConceptsL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Statements":
                sb.append("StatementsL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Loops":
                sb.append("LoopsL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Data Types":
                sb.append("DataTypes from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Polymorphism":
                sb.append("PolymorphismL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Encapsulation":
                sb.append("EncapsulationL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Inheritence":
                sb.append("InheritenceL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "This keyword":
                sb.append("ThisL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Super keyword":
                sb.append("SuperL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Final keyword":
                sb.append("FinalL from " + TABLE_USERS + " WHERE Username = " + '\"').append(username).append('\"');
                break;
        }
        
        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(sb.toString());


            if (set.next()) {
                int i = set.getInt(1);
                if (i == 1) return true;
                else return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void setLesson(String username, String lesson) {
        Connection con = null;
        StringBuilder sb = new StringBuilder("UPDATE Users SET ");
        switch (lesson) {
            case "Basics":
                sb.append("BasicsL =? WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Keywords":
                sb.append("KeyWordsL=?  WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "OopConcepts":
                sb.append("OOPConceptsL=? WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Statements":
                sb.append("StatementsL=? WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Loops":
                sb.append("LoopsL=? WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Data Types":
                sb.append("DataTypes=?  WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Polymorphism":
                sb.append("PolymorphismL=? WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Encapsulation":
                sb.append("EncapsulationL=? WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Inheritence":
                sb.append("InheritenceL=?  WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "This keyword":
                sb.append("ThisL=?  WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Super keyword":
                sb.append("SuperL=?  WHERE Username = " + '\"').append(username).append('\"');
                break;
            case "Final keyword":
                sb.append("FinalL=?  WHERE Username = " + '\"').append(username).append('\"');
                break;
        }

        try {
            con = connect();
            PreparedStatement statement = con.prepareStatement(sb.toString());
            statement.setInt(1, 1);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> queryAllQuestions() {
        Connection con = null;
        String query1 = "Select Question from KeyWords";
        String query2 = "Select Question from OOPConcepts";
        String query3 = "Select Question from Basics";
        try {
            ArrayList<String> questions = new ArrayList<>();
            con = connect();
            Statement statement = con.createStatement();
            Statement statement2 = con.createStatement();
            Statement statement3 = con.createStatement();
            ResultSet set = statement.executeQuery(query1);
            ResultSet set2 = statement2.executeQuery(query2);
            ResultSet set3 = statement3.executeQuery(query3);

            while (set.next()) {
                questions.add(set.getString(1));
            }
            while (set2.next()) {
                questions.add(set2.getString(1));
            }
            while (set3.next()) {
                questions.add(set3.getString(1));
            }
            return questions;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void insertQuizInHistory(String username, String quiz, int points) {
        Connection con = null;
        String query = "INSERT INTO History(Username,Quiz,Points) values(?,?,?)";

        try {
            con = connect();
            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, quiz);
            statement.setInt(3, points);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<History> getFromHistory(String username) {
        Connection con = null;
        String query = "SELECT * FROM History WHERE Username = "
                + '\"' + username + '\"';
        try {
            con = connect();
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query);
            ArrayList<History> arr = new ArrayList<>();

            while (set.next()) {
                History h = new History();
                h.setPoints(set.getInt(3));
                h.setQuiz(set.getString(2));
                h.setUsername(set.getString(1));
                arr.add(h);
            }
            return arr;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

