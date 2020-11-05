package connection;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.AES;
import utilities.AES;
import Forms.AppHome;
import Forms.AppHome;
import javax.swing.table.DefaultTableModel;

public class ConnectionManager {

    private static int idUserAccount;
    private static int idLoc = 6;
    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private final String secret = "ssshhhhhhhhhhh!!!!";
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    private static final String connectionString = "jdbc:mysql://localhost:3306/jobsearchapp?user=root";
    private static Connection connection = null;
    public static int numberOfOpenedConnections = 0;

    public ConnectionManager() {
        getConnection();
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(connectionString);
            }
        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
        }
        numberOfOpenedConnections++;
        return connection;
    }

    public static boolean connectionIsOpen() {
        try {
            return !connection.isClosed();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return false;
    }

    public static void close() {
        try {
            connection.close();
            numberOfOpenedConnections--;
        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
        }
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    public void test() {
        //step3 create the statement object  
        File f = new File("id.txt");
        String line = new String();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((line = br.readLine()) != null) {
                    idUserAccount = Integer.valueOf(line);
                }
            } catch (IOException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(String.valueOf(++idUserAccount));
        } catch (IOException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean login(String username, String password) {

        //code 
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select EMAIL,PASSWORD,USERNAME from USER_ACCOUNT");
            while (rs.next()) {
                if (((username.equals(rs.getString(1))) || username.equals(rs.getString(3))) && password.equals(AES.decrypt(rs.getString(2), secret))) {
                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                        Date date = new Date(System.currentTimeMillis());

                        pstmt = con.prepareStatement("Insert into USER_LOG (LOGINDATE,ID_USERACCOUNT)values (?, (Select ID_USERACC From USER_ACCOUNT where email=?))");
                        pstmt.setString(1, formatter.format(date));
                        pstmt.setString(2, rs.getString(1));

                        rs = pstmt.executeQuery();

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return false;
    }

    public void InsertToTable(String cOrJs, String dob, String email, String password, String Gender, String PhoneNumber1, String PhoneNumber2, String Username, String path) {
        test();
        try {
            pstmt = con.prepareStatement("INSERT INTO USER_ACCOUNT (ID_USERACC,ID_USERTYPE_FK,DATE_OF_BIRTH, EMAIL, PASSWORD, GENDER, PHONENUMBER1,PHONENUMBER2,USERNAME, PROFILE_PICTURE) "
                    + "VALUES (?,(Select ID_USERTYPE from USER_TYPE where USERTYPE_NAME=?),?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, idUserAccount);
            pstmt.setString(2, cOrJs);
            pstmt.setString(3, dob);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.setString(6, Gender);
            pstmt.setString(7, PhoneNumber1);
            pstmt.setString(8, PhoneNumber2);
            pstmt.setString(9, Username);
            pstmt.setString(10, path);

            rs = pstmt.executeQuery();

            idUserAccount++;

            //con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void InsertCompany(String cname, String cdesc, String estabDate, String cwebsite, String p1, String p2, String country, String Field,
            String street, String Governorate, String Country, String building, String floornb, String City, String Region) {

        try {
            pstmt = con.prepareStatement("Insert into COMPANY (COMPAN_NAME,COMPANY_DESCRIPTION,ESTABLISHEMENTDATE,"
                    + "COMPANY_WEBSITE,PHONENUMBER1,PHONENUMBER2,COUNTRY,ID_BUSINESSFIELD)" + "VALUES (?,?,"
                    + ",to_date(?,\'DD-MON-RR\'),?,?, ?,?,(SELECT FIEDL_ID FROM BUSINESS_FIELD WHERE FIELD_NAME = ?)) \n");

            pstmt.setString(1, cname);
            pstmt.setString(2, cdesc);
            pstmt.setString(3, estabDate);
            pstmt.setString(4, cwebsite);
            pstmt.setString(5, p1);
            pstmt.setString(6, p2);
            pstmt.setString(7, country);
            pstmt.setString(8, Field);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pstmt = con.prepareStatement("Insert into COMPANYLOCATION (STREETADDRESS,GOVERNORATE,COUNTRY,BUILDING,FLOORNB,CITY,REGION) values (?, ?,?,?,?,?,?) \n");

            pstmt.setString(1, street);
            pstmt.setString(2, Governorate);
            pstmt.setString(3, Country);
            pstmt.setString(4, building);
            pstmt.setString(5, floornb);
            pstmt.setString(6, City);
            pstmt.setString(7, Region);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pstmt = con.prepareStatement("Insert into COMPANY_AND_LOCATION (COMPANYLOCATION_ID,COMPANY_ID) values "
                    + "((Select ID_COMPANYLOCATION FROM CompanyLocation where streetaddress=? and Governorate=? and Country=? and Building=? and floornb=?  and city=? and Region=?)"
                    + "(Select ID_COMPANY FROM Company where Compan_name=? )) \n");

            pstmt.setString(1, street);
            pstmt.setString(2, Governorate);
            pstmt.setString(3, Country);
            pstmt.setString(4, building);
            pstmt.setString(5, floornb);
            pstmt.setString(6, City);
            pstmt.setString(7, Region);
            pstmt.setString(8, cname);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void InsertJobSeeker(String fname, String lname, String email, String Street, String City, String Region, String Governorate, String Country,
            String Skill, String SkillLevel, String certificate, String major, String minor, Float GPA, String Uni,
            int nbOfExp, String lastJob, String jobTitle, String CompanyName, String desc) {

        try {
            pstmt = con.prepareStatement("Insert into JOBSEEKERLOCATION (STREETADDRESS,CITY,REGION,GOVERNORATE,COUNTRY, ID_JOBSEEKERLOCATION) values (?, ?, ?, ?, ?, ?) \n");

            pstmt.setString(1, Street);
            pstmt.setString(2, City);
            pstmt.setString(3, Region);
            pstmt.setString(4, Governorate);
            pstmt.setString(5, Country);
            pstmt.setInt(6, idLoc);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pstmt = con.prepareStatement("Insert into JOBSEEKER (FIRSTNAME,LASTNAME,JOBSEEKERLOCATION_ID,USERACCOUNT_ID) values "
                    + "(?,?,(Select ID_JOBSEEKERLOCATION from JOBSEEKERLOCATION where STREETADDRESS=? and CITY=? and REGION=? and GOVERNORATE=? and COUNTRY=?),"
                    + "(Select ID_USERACC from User_account where email=?)) \n");

            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, Street);
            pstmt.setString(4, City);
            pstmt.setString(5, Region);
            pstmt.setString(6, Governorate);
            pstmt.setString(7, Country);
            pstmt.setString(8, email);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pstmt = con.prepareStatement("Insert into JOBSEEKER_SKILL (SKILL_LEVEL,ID_SKILLS,JOBSEEKER_ID) values (?, (Select ID_SKILLS From Skills where SkillName=?),"
                    + "(Select ID_USERACC from USER_ACCOUNT where email=?)) \n");

            pstmt.setString(1, SkillLevel);
            pstmt.setString(2, Skill);
            pstmt.setString(3, email);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pstmt = con.prepareStatement("Insert into EDUCATIONAL_DETAILS (CERTIFICATE_DEGREE_NAME,MAJOR,MINOR,GPA,UNIVERSITY_ID,JOBSEEKER_ID) values "
                    + "(?, ?, ?, ?,(Select ID_UNIVERSITY from University where UNIVERSITY_NAME=?),"
                    + "(Select ID_USERACC from USER_ACCOUNT where email=?)) \n");

            pstmt.setString(1, certificate);
            pstmt.setString(2, major);
            pstmt.setString(3, minor);
            pstmt.setString(4, Float.toString(GPA));
            pstmt.setString(5, Uni);
            pstmt.setString(6, email);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pstmt = con.prepareStatement("Insert into EXPERIENCE (NBOFYEARSOFEXPRIENCE,LASTJOB,JOB_TITLE,COMPANYNAME,DESCRIPTION,JOBSEEKER_ID) values "
                    + "(?, ?, ?, ?, ?,(Select ID_USERACC from USER_ACCOUNT where email= ?)) \n");

            pstmt.setString(1, Integer.toString(nbOfExp));
            pstmt.setString(2, lastJob);
            pstmt.setString(3, jobTitle);
            pstmt.setString(4, CompanyName);
            pstmt.setString(5, desc);
            pstmt.setString(6, email);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void InsertJobOffer(String street, String city, String region, String gov, String country,
            String employer, String creationdate, String jobdesc, String jobtype, String email, String CompanyName,
            String Skill, String requiredlevel) {

        try {
            pstmt = con.prepareStatement("Insert into JOBLOCATION (STREETADDRESS,CITY,REGION,GOVERNORATE,COUNTRY) values (?, ?, ?, ?, ?);\n");

            pstmt.setString(1, street);
            pstmt.setString(2, city);
            pstmt.setString(3, region);
            pstmt.setString(4, gov);
            pstmt.setString(5, country);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pstmt = con.prepareStatement("Insert int JOB_OFFER(EMPLOYERNAME,CREATION_DATE,JOBDESCRIPTION,JOBTYPE_ID,JOB_LOCATION_ID,USERACCOUNT_ID,COMPANY_ID) values "
                    + "(?, to_date(?,\'DD-MON-RR\'),?, (Select ID_JOBTYPE from JOB_TYPE where JOBTYPE=?),"
                    + "(Select ID_USERACC from USER_ACCOUNT where email=?),"
                    + "(Select ID_COMPANY from Company where COMPAN_NAME=?)); \n");

            pstmt.setString(1, employer);
            pstmt.setString(2, creationdate);
            pstmt.setString(3, jobdesc);
            pstmt.setString(4, jobtype);
            pstmt.setString(5, email);
            pstmt.setString(6, CompanyName);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            pstmt = con.prepareStatement("Insert into JOB_OFFER_SKILLS (REQUIRED_SKILL_LEVEL,JOBOFFER_ID,SKILLS_ID) values "
                    + "(?,(Select ID_JOBOFFER from job_offer where employername=? and JOBDESCRIPTION=? and CREATION_DATE=to_date(?,\'DD-MON-RR\')),"
                    + "(Select ID_SKILLS From Skills where SkillName=?)); \n");

            pstmt.setString(1, requiredlevel);
            pstmt.setString(2, employer);
            pstmt.setString(3, jobdesc);
            pstmt.setString(4, creationdate);
            pstmt.setString(5, Skill);

            rs = pstmt.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void DisplayJobseekers(String username) {

        try {
            pstmt = con.prepareStatement("Select FIRSTNAME, LASTNAME from Jobseeker where USERACCOUNT_ID = (select ID_USERACC from USER_ACCOUNT where username = ?)");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                AppHome.jTextField1.setText(rs.getString(1));
                AppHome.jTextField2.setText(rs.getString(2));
            }

            pstmt = con.prepareStatement("Select city, Region, country from jobseekerlocation Where id_Jobseekerlocation = (select Jobseekerlocation_id from jobseeker where USERACCOUNT_ID = (select ID_USERACC from USER_ACCOUNT where username = ?))");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                AppHome.jTextField3.setText(rs.getString(1));
                AppHome.jTextField6.setText(rs.getString(2));
                AppHome.jTextField7.setText(rs.getString(3));
            }

            pstmt = con.prepareStatement("Select EMAIL, PHONENUMBER1 from USER_ACCOUNT where ID_USERACC = (select ID_USERACC from USER_ACCOUNT where username = ?)");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                AppHome.jTextField8.setText(rs.getString(1));
                AppHome.jTextField9.setText(rs.getString(2));
            }

            pstmt = con.prepareStatement("Select CERTIFICATE_DEGREE_NAME, MAJOR, GPA from EDUCATIONAL_DETAILS where JOBSEEKER_ID = (select ID_USERACC from USER_ACCOUNT where username = ?)");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                AppHome.jTextField10.setText(rs.getString(1));
                AppHome.jTextField11.setText(rs.getString(2));
                AppHome.jTextField12.setText(rs.getString(3));
            }

            pstmt = con.prepareStatement("Select NBOFYEARSOFEXPRIENCE, LASTJOB from EXPERIENCE where JOBSEEKER_ID = (select ID_USERACC from USER_ACCOUNT where username = ?)");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                AppHome.jTextField13.setText(rs.getString(1));
                AppHome.jTextField14.setText(rs.getString(2));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void DisplayCompanies() {

        String statement = "SELECT C.COMPAN_NAME, C.COMPANY_DESCRIPTION, C.ESTABLISHMENTDATE, C.COMPANY_WEBSITE, "
                + "C.PHONENUMBER1, B.FIELD_NAME, L.STREETADDRESS,L.BUILDING,L.FLOORNB, L.CITY,L.REGION "
                + "FROM COMPANY C\n"
                + "JOIN BUSINESS_FIELD B ON C.ID_BUSINESSFIELD=B.FIEDL_ID\n"
                + "JOIN COMPANY_AND_LOCATION CL ON C.ID_COMPANY=CL.COMPANY_ID\n"
                + "JOIN COMPANYLOCATION L ON CL.COMPANYLOCATION_ID=L.ID_COMPANYLOCATION\n"
                + ";";

        try {
            stmt = con.createStatement();

            rs = stmt.executeQuery(statement);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void searchjobseeker(String m) {
        try {
            pstmt = con.prepareStatement(" Select\n"
                    + "j.firstname,\n"
                    + "j.lastname,\n"
                    + "e.nbofyearsofexprience,\n"
                    + "s.skillname,\n"
                    + "ua.email,\n"
                    + "ed.CERTIFICATE_DEGREE_NAME\n"
                    + "from skills s\n"
                    + "Join jobseeker_skill jss on s.id_skills = jss.id_skills\n"
                    + "Join experience e on jss.jobseeker_id = e.jobseeker_id\n"
                    + "Join jobseeker j on e.jobseeker_id = j.useraccount_id\n"
                    + "Join EDUCATIONAL_DETAILS ed on j.USERACCOUNT_ID=ed.JOBSEEKER_ID\n"
                    + "Join User_Account ua on j.useraccount_id = ua.Id_useracc\n"
                    + "where s.skillname like ? or j.firstname like ? "
                    + "or j.lastname like ? or ua.email like ?");

            pstmt.setString(1, "%" + m + "%");
            pstmt.setString(2, "%" + m + "%");
            pstmt.setString(3, "%" + m + "%");
            pstmt.setString(4, "%" + m + "%");

            rs = pstmt.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) AppHome.Table.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Object User[] = {rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getInt("nbofyearsofexprience"),
                    rs.getString("skillname"),
                    rs.getString("email"),
                    rs.getString("CERTIFICATE_DEGREE_NAME")
                };
                dtm.addRow(User);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void SearchJobOffer(String m) {

        try {
            pstmt = con.prepareStatement("Select\n"
                    + "jo.EMPLOYERNAME,\n"
                    + "jo.JOBDESCRIPTION,\n"
                    + "jt.JOBTYPE,"
                    + "c.COMPAN_NAME,"
                    + "s.SKILLNAME,"
                    + "jos.required_skill_level\n"
                    + "from job_offer jo\n"
                    + "join company c on jo.COMPANY_ID=c.ID_COMPANY\n"
                    + "Join job_type jt on jo.jobtype_id = jt.id_jobtype\n"
                    + "join job_offer_skills jos on jo.id_joboffer = jos.joboffer_id\n"
                    + "join skills s on jos.SKILLS_ID=s.ID_SKILLS\n"
                    + "where jo.EMPLOYERNAME like ? or JOBDESCRIPTION like ? or jt.JOBTYPE like ? or COMPAN_NAME like ? or s.SKILLNAME like ? or jos.required_skill_level like ?\n");

            pstmt.setString(1, "%" + m + "%");
            pstmt.setString(2, "%" + m + "%");
            pstmt.setString(3, "%" + m + "%");
            pstmt.setString(4, "%" + m + "%");
            pstmt.setString(5, "%" + m + "%");
            pstmt.setString(6, "%" + m + "%");

            rs = pstmt.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) AppHome.Table1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Object Job[] = {rs.getString("EMPLOYERNAME"),
                    rs.getString("JOBDESCRIPTION"),
                    rs.getString("JOBTYPE"),
                    rs.getString("COMPAN_NAME"),
                    rs.getString("SKILLNAME"),
                    rs.getString("required_skill_level")
                };
                dtm.addRow(Job);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void searchCompany(String m) {

        try {
            pstmt = con.prepareStatement("Select\n"
                    + "c.COMPAN_NAME,\n"
                    + "c.COMPANY_DESCRIPTION,\n"
                    + "c.COMPANY_WEBSITE,"
                    + "c.PHONENUMBER1,"
                    + "c.PHONENUMBER2,"
                    + "c.COUNTRY\n"
                    + "from Company c\n"
                    + "where c.COMPAN_NAME like ? or c.COMPANY_DESCRIPTION like ? or c.COMPANY_WEBSITE like ? or c.PHONENUMBER1 like ? or c.PHONENUMBER2 like ? or c.COUNTRY like ?\n");

            pstmt.setString(1, "%" + m + "%");
            pstmt.setString(2, "%" + m + "%");
            pstmt.setString(3, "%" + m + "%");
            pstmt.setString(4, "%" + m + "%");
            pstmt.setString(5, "%" + m + "%");
            pstmt.setString(6, "%" + m + "%");

            rs = pstmt.executeQuery();

            DefaultTableModel dtm = (DefaultTableModel) AppHome.Table2.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Object Company[] = {rs.getString("COMPAN_NAME"),
                    rs.getString("COMPANY_DESCRIPTION"),
                    rs.getString("COMPANY_WEBSITE"),
                    rs.getString("PHONENUMBER1"),
                    rs.getString("PHONENUMBER2"),
                    rs.getString("COUNTRY")
                };
                dtm.addRow(Company);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void InsertImage(String username, String Image) {

        try {
            pstmt = con.prepareStatement("UPDATE User_Account set PROFILE_PICTURE = ? where User_Account.USERNAME = ?");

            pstmt.setString(1, Image);
            pstmt.setString(2, username);

            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static File getImage(String username) {
        String path = new String("C:\\Users\\joelt\\Documents\\NetBeansProjects\\Job-Search-Project-master\\src\\javaapplication1\\Media\\Default-Profile-Picture.jpg");
        File image = new File(path);
        try {

            pstmt = con.prepareStatement("Select PROFILE_PICTURE from User_Account where user_account.username = ?");

            pstmt.setString(1, username);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                path = rs.getString("PROFILE_PICTURE");
            }
            return new File(path);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return image;
    }

}
