import java.util.Scanner;

class app {
    public static void main(String[] args) {
        // test abc = new test("input");
        // abc.printInput();
        RoleMenu();
    }

    // Menu to select role to simulate
    public static void RoleMenu() {
        System.out.println("Select Role: ");
        System.out.print("1: Trainee\n2: Finance Manager\n3: Manager\n");

        // Reading an int to choose a role
        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();

        
        if (userInput == 1) { 
            traineeOption();
        } else if (userInput == 2) {
            financeManagerOption();
        } else if (userInput == 3) {
            managerOption();
        } else {
            System.out.println("Input was invalid");
        }

        in.close();
    }

    public static void traineeOption() {
        // This user is just an example trainee, that was initialised for the purposes of this showcase. 
        // Normally the user themselves would login and the system would then grab the user's info.
        trainee user = new trainee(0001, "John Proctor", "JohnProctor43", "applebubblegum");
        System.out.println("1: File Complaint");
        System.out.println("2: Request Refund");

        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();
        String userReason = in.nextLine();
        if (userInput == 1) {
            //File Complaint
            System.out.println("File Complaint has been chosen.");
            System.out.println("Enter your complaint: ");
            String userComplaint = in.nextLine();
            // The user's feedback/complaint would be sent into the system
            user.sendComplaint(userComplaint);
            // Afterwards the user would get a Thank You message and notification about an email that will appear when feedback has been looked at.
            System.out.println("Thank you for the feedback. We will send you an email when the feedback has been looked at.");
        } else if (userInput == 2) {
            //Refund Request
            System.out.println("Refund Request has been chosen.");
            user.viewCourses();
            System.out.println("Provide a reason for refund: ");
            userReason = in.nextLine();
            //The user's request will be sent into the system.
            user.requestRefund("Software Engineering Fundamental's", userReason);
            // When the request has been successfully sent to the system, the trainee will get a message, saying Thank You but
            // also notifying them that they will get an email when the request has been looked at.
            System.out.println("Thank you for sending a request. An email will be sent when the request has been looked at.");
        }

        in.close();
    }

    public static void financeManagerOption() {
        financeManager user = new financeManager(0002, "Alfred Charles", "AlfredCharles77", "DonkeyBottles93");
        System.out.println("1: Assess Refund Requests");
        Scanner in = new Scanner(System.in);

        int userInput = in.nextInt();
        in.nextLine();
        if (userInput == 1) {
            System.out.println("Select a refund request to review:");
            user.viewRefundRequests();
            int reviewChoice = in.nextInt();
            in.nextLine();
            if (reviewChoice == 1) {
                System.out.println("Title: I dislike this course");
                System.out.println("Date: 10/06/2023");
                System.out.println("Course: Software Engineering Fundamental's");
                System.out.println("Course start date: 15/05/2023");
                System.out.println("Description: ");
                System.out.println("After trying out the course for the past couple of weeks, I've found that I dislike this course.");
                System.out.println("I don't have an interest in the course anymore.");

                System.out.println("\n\n1: Accept Request\n2: Deny Request");
                int acceptOrDeny = in.nextInt();
                in.nextLine();

                user.acceptOrDeny(acceptOrDeny);
            } else if (reviewChoice == 2) {
                System.out.println("Title: Emergency situation at home");
                System.out.println("Date: 10/05/2023");
                System.out.println("Course: Software Engineering Fundamental's");
                System.out.println("Course start date: 15/05/2023");
                System.out.println("Description: ");
                System.out.println("An emergency has occured back at home, so I will not be able to attend the first session in 3 days time.");
                System.out.println("As I don't want to waste money, I would like to request a refund.");

                System.out.println("\n\n1: Accept Request\n2: Deny Request");
                int acceptOrDeny = in.nextInt();
                in.nextLine();

                user.acceptOrDeny(acceptOrDeny);
            }
        }
        in.close();
    }

    // Menu option for manager
    public static void managerOption() {
        //Temp manager user
        manager user = new manager(0003, "Manager Guy", "ManagerGuy123123", "AlphaPlateFour");
        // The manager would have more options but for this scenario we only need view complaints.
        System.out.println("1: View Complaints ");
        Scanner in = new Scanner(System.in);

        int userInput = in.nextInt();
        in.nextLine();

        if (userInput == 1) {
            // Complaints are then displayed to the manager
            System.out.println("Complaint's: ");
            user.viewComplaints();
            System.out.println("Select a complaint to review:");
            int complaintChoice = in.nextInt();
            in.nextLine();

            if (complaintChoice == 1) {
                // Complaint chosen is expanded
                System.out.println("Title: Stream quality is bad.");
                System.out.println("Description: \nI'm currently enrolled into the online class rather than the face to face class.");
                System.out.println("The stream quality for the online classes have been absolutely terrible. I'm not sure if ");
                System.out.println("its a camera issue or a connection issue however the video quality feels like.");
                System.out.println("I'm watching it in 360p. Which sure could have been fine back then, however with technology nowadays");
                System.out.println("I feel like it's unacceptable especially when the prices for the courses aren't exactly small."); 

                // Manager then types in their response which will get sent to the system.
                System.out.println("Please type your response to the complaint: ");
                String response = in.nextLine();
                user.respondToComplaints(response);
            } else if (complaintChoice == 2) {
                // Complaint chosen is expanded
                System.out.println("Title: Course too hard.");
                System.out.println("Description: \nI'm currently enrolled in the Software Engineering Fundamental's course and");
                System.out.println("i find the course to be too hard as of currently. I believe the structure of the course could be better.");
                System.out.println("The courses feel too rushed.");

                // Manager then types in their response which will get sent to the system.
                System.out.println("Please type your response to the complaint: ");
                String response = in.nextLine();
                user.respondToComplaints(response);
            }
        }
        in.close();
    }

}