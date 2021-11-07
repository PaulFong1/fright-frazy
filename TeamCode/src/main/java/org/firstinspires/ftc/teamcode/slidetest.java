package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
// Created  for 16887.
@Autonomous(name="slidetest", group="Simple")
//@Disabled
public class slidetest extends BaseRobot {

    @Override
    public void init() {
        super.init();
        DEBUG = true;
    }

    @Override
    public void start() {
        super.start();
//        lift1.setPower(0.0);            // Don't need LIFT for this mode
//        lift1.setTargetPosition(0);
    }

    @Override
    public void loop() {
        // Assumptions: the rack is down
        // OpMode.time (double) number of seconds this op mode has been running, this is updated before every call to loop
        if (time<4.5) {
            linearSlide.setPower(0.2);
            //reset_drive_encoders();
        }
        else if (time>4.5 && time <5.0) {
            linearSlide.setPower(-0.2);
            //reset_drive_encoders();
        } else {
            linearSlide.setPower(0);
//            linearSlideSetPosition(linearSlide, 1);
        }
//            if (DEBUG) telemetry.addData("Forward 5, then LEFT: ", stage);
 //           super.loop();
    }
}
