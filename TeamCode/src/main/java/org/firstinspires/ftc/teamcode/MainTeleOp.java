package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// Created for 16887.
@TeleOp(name="Main TeleOp", group="TeleOp")
//@Disabled
public class MainTeleOp extends BaseRobot {
    int stage = 0;
    @Override
    public void init() { super.init(); }
    @Override
    public void start() { super.start(); }
    @Override
    public void loop() {

        //        tankanum_original(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);
        tankanum_drive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);

        // Mini movements
        if ((gamepad1.right_stick_y == 0) && (gamepad1.left_stick_y == 0) && (gamepad1.right_stick_x == 0)) {
  //          if (gamepad1.dpad_up) auto_drive(0.75, 0.5);
            //       else if (gamepad1.dpad_down) auto_drive(-0.75, 0.5);
              reset_drive_encoders();
        }
        // Turn the top spinning wheel: left for clockwise and right for anticlockwise

        if (gamepad1.left_bumper)       topSpin.setPower(1);
        else if (gamepad1.right_bumper) topSpin.setPower(-1);
        else                            topSpin.setPower(0);



        //turn the motor for the linear slide
        if (gamepad1.a)       linearSlide.setPower(0.5); //extend
        else if (gamepad1.b) linearSlide.setPower(-0.5); //retract
        else                            linearSlide.setPower(0);

        if (gamepad1.x)
        {
            if (stage<2 && get_linearSlide_motor_enc() < 510)
            {
                stage++;
                linearSlideSetPosition(linearSlide, stage, 0.3);
            }
        }

        else if (gamepad1.y)
        {
            if (stage>0 && get_linearSlide_motor_enc() >  490) {
                stage--;
                linearSlideSetPosition(linearSlide, stage, 0.3);
            }

        }
        else linearSlide.setPower(0);
        if (gamepad1.left_stick_button) DEBUG = !DEBUG; // Toggle the debug flag
        super.loop();


        if (gamepad1.left_stick_button) DEBUG = !DEBUG; // Toggle the debug flag

        if (gamepad1.dpad_down)
        {
            rotate1.setPower(-0.2);
            rotate2.setPower(-0.2);
        }
        if (gamepad1.dpad_up)
        {
            rotate1.setPower(0.2);
            rotate2.setPower(0.2);
        }

    }
}
