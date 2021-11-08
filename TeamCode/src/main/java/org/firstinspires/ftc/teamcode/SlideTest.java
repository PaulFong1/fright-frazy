package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

// Created  for 16887.
@Autonomous(name="Slide Test", group="Simple")
//@Disabled
public class SlideTest extends BaseRobot {

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
        rotate1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);  // so that the slide won't fall
    }

    @Override
    public void loop() {
        // Assumptions: the slide is in an angle so that it can move up and down
        // OpMode.time (double) number of seconds this op mode has been running, this is updated before every call to loop
        if (time<5.0) {
            linearSlide.setPower(0.15);  // Extend
            //reset_drive_encoders();
        } else if (time <10.0) {
            linearSlide.setPower(-0.05);// Contract
            //reset_drive_encoders();
        } else if (time <15.0) {
            rotate1.setTargetPosition(-10);  // down
//            rotate1.setDirection(DcMotorSimple.Direction.REVERSE);
            rotate1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rotate1.setPower(-0.2);
            while (rotate1.isBusy()) {}
            rotate1.setPower(0.0);
            linearSlide.setPower(0.0);
            linearSlideSetPosition(linearSlide, 400);
        } else if (time<20.0) {
            rotate1.setTargetPosition(10);  // up
//            rotate1.setDirection(DcMotorSimple.Direction.FORWARD);
            rotate1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rotate1.setPower(0.2);
            while (rotate1.isBusy()) {}
            rotate1.setPower(0.0);
        } else if (time<25.0) {
            linearSlideSetPosition(linearSlide, 600);
        } else {
            linearSlideSetPosition(linearSlide, 50);
        }
        if (DEBUG) {
            telemetry.addData("Front curr pos:", "Left=%d, Right=%d", get_leftFront_motor_enc(), get_rightFront_motor_enc());
            telemetry.addData("Back  curr pos:", "Left=%d, Right=%d", get_leftBack_motor_enc(), get_rightBack_motor_enc());
            telemetry.addData("Front power: ", "Left=%.2f, Right=%.2f", leftFront.getPower(), rightFront.getPower());
            telemetry.addData("Back  power: ", "Left=%.2f, Right=%.2f", leftBack.getPower(), rightBack.getPower());
            telemetry.addData("linearSlide:", "pos=%d, power=%.2f", get_linearSlide_motor_enc(), linearSlide.getPower());
            telemetry.addData("topSpin:", "pos=%d, power=%.2f", get_topSpin_motor_enc(), topSpin.getPower());
            telemetry.addData("rotate1:", "pos=%d, power=%.2f", get_rotate1_motor_enc(), rotate1.getPower());
        }
//            if (DEBUG) telemetry.addData("Forward 5, then LEFT: ", stage);
 //           super.loop();
    }
}
