import java.awt.*;
import java.awt.event.*;

class LoginFrame extends Frame implements ActionListener {
    TextField tfUsername, tfPassword;
    Button btnLogin;
    Label lblMessage;
    
    LoginFrame() {
        setTitle("Bus Reservation - Login");
        setSize(600, 400);
        setLayout(null);
        
        // Load Background Image
        Image img = Toolkit.getDefaultToolkit().getImage("bus_bg.jpg");
        CustomCanvas canvas = new CustomCanvas(img);
        canvas.setBounds(0, 0, 600, 400);
        add(canvas);
        
        Label lblUsername = new Label("Username:");
        lblUsername.setBounds(150, 120, 80, 30);
        add(lblUsername);
        
        tfUsername = new TextField();
        tfUsername.setBounds(250, 120, 150, 30);
        add(tfUsername);
        
        Label lblPassword = new Label("Password:");
        lblPassword.setBounds(150, 160, 80, 30);
        add(lblPassword);
        
        tfPassword = new TextField();
        tfPassword.setEchoChar('*');
        tfPassword.setBounds(250, 160, 150, 30);
        add(tfPassword);
        
        btnLogin = new Button("Login");
        btnLogin.setBounds(250, 200, 100, 30);
        btnLogin.addActionListener(this);
        add(btnLogin);
        
        lblMessage = new Label();
        lblMessage.setBounds(200, 250, 200, 30);
        add(lblMessage);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        
        if (username.equals("admin") && password.equals("admin")) {
            lblMessage.setText("Login Successful!");
            new SeatSelectionFrame(); // Open Seat Selection
            dispose();
        } else {
            lblMessage.setText("Invalid Login!");
        }
    }
}

// Frame for Seat Selection
class SeatSelectionFrame extends Frame implements ActionListener {
    Choice seatChoice;
    Button btnBook;
    
    SeatSelectionFrame() {
        setTitle("Bus Reservation - Seat Selection");
        setSize(600, 400);
        setLayout(null);
        
        Label lblSelect = new Label("Select Your Seat:");
        lblSelect.setBounds(220, 100, 200, 30);
        add(lblSelect);
        
        seatChoice = new Choice();
        for (int i = 1; i <= 10; i++) {
            seatChoice.add("Seat " + i);
        }
        seatChoice.setBounds(220, 140, 100, 30);
        add(seatChoice);
        
        btnBook = new Button("Confirm Booking");
        btnBook.setBounds(220, 200, 120, 30);
        btnBook.addActionListener(this);
        add(btnBook);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        new BookingConfirmationFrame(seatChoice.getSelectedItem());
        dispose();
    }
}

// Booking Confirmation Frame
class BookingConfirmationFrame extends Frame {
    BookingConfirmationFrame(String seatNumber) {
        setTitle("Bus Reservation - Confirmation");
        setSize(600, 400);
        setLayout(null);
        
        Label lblConfirm = new Label("Your " + seatNumber + " has been booked!");
        lblConfirm.setBounds(180, 150, 250, 30);
        add(lblConfirm);
        
        setVisible(true);
    }
}

// Custom Canvas for Background Image
class CustomCanvas extends Canvas {
    Image img;
    
    CustomCanvas(Image img) {
        this.img = img;
    }
    
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

// Main Class
public class BusReservationSystem {
    public static void main(String[] args) {
        new LoginFrame();
    }
}
