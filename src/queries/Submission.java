package queries;

import java.sql.*;

public class Submission {

    public static void printTable(ResultSet rs) {
        try {
            System.out.println("+---------------+---------------+----------+----------+-----------+");
            System.out.println("|SubmissionID   |ContestID      |ProblemID |Username  |Verdict    |");
            System.out.println("+---------------+---------------+----------+----------+-----------+");
            do {
                System.out.printf("|%-15s|%-15s|%-10d|%-10d|%-11s|\n", rs.getString(1), rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4));
            } while (rs.next());
            System.out.println("+---------------+---------------+----------+----------+-----------+");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayAll(Connection con) {
            try {
                Statement st = con.createStatement();
                ResultSet result1 = st.executeQuery("select * from submission");

                if (result1.next() == false) {
                    System.out.println("No Result from Submissions");
                } else {
                    System.out.println("Submissions Table :\n");
                    printTable(result1);
                }
                System.out.printf("\n");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    public static void insertSubmissions(Connection con, String tuple) {
        try {
            String[] args = tuple.split(" ");
            String query = " insert into Submission(SubmissionID,ContestID,ProblemID,UserName,Verdict) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, args[0]);
            preparedStmt.setString(2, args[1]);
            preparedStmt.setInt(3, Integer.parseInt(args[2]));
            preparedStmt.setInt(4, Integer.parseInt(args[3]));
            preparedStmt.setString(5, args[4]);
            preparedStmt.execute();
            System.out.println("Inserted successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void updateVerdictBySub(Connection con, String SubmissionID, String ver) {
        try {
            String query = "update Submission set verdict = ? where SubmissionID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, ver);
            preparedStmt.setString(2, SubmissionID);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Update failed!!!");
            } else {
                System.out.println("Updated successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void updateVerdictByProb(Connection con, String ProblemID, String ver) {
        try {
            String query = "update Submission set verdict = ? where ProblemID = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, ver);
            preparedStmt.setString(2, ProblemID);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Update failed!!!");
            } else {
                System.out.println("Updated successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchBySubId(Connection con, String id) {
        try {
            String query = "select * from Submission where SubmissionID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Submissions");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByConId(Connection con, String id) {
        try {
            String query = "select * from Submission where ContestID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Submissions");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void searchByProbId(Connection con, String id) {
        try {
            String query = "select * from Submission where ProblemID = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next() == false) {
                System.out.println("No Result from Submissions");
            } else {
                printTable(rs);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteSubBySub(Connection con, String id) {
        try {
            String query = "delete from user where SubmissionID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a Submission");
            } else {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteSubByCon(Connection con, String id) {
        try {
            String query = "delete from user where ContestID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a Submission");
            } else {
                System.out.println("Deleted");
                
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }

    public static void deleteSubByProb(Connection con, String id) {
        try {
            String query = "delete from user where ProblemID=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, id);
            int rs = preparedStmt.executeUpdate();
            if (rs == 0) {
                System.out.println("Id " + id + " is not a Submission");
            } else {
                System.out.println("Deleted");
                
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong command\nType \"-h\" to get help");
        }
    }


}