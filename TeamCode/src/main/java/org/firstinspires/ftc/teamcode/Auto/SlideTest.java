package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.BaseRobot;

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
        actuator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);  // so that the slide won't fall
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
            actuator.setTargetPosition(-10);  // down
//            actuator.setDirection(DcMotorSimple.Direction.REVERSE);
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            actuator.setPower(-0.2);
            while (actuator.isBusy()) {}
            actuator.setPower(0.0);
            linearSlide.setPower(0.0);
            linearSlideSetPosition(linearSlide, 400);
        } else if (time<20.0) {
            actuator.setTargetPosition(10);  // up
//            actuator.setDirection(DcMotorSimple.Direction.FORWARD);
            actuator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            actuator.setPower(0.2);
            while (actuator.isBusy()) {}
            actuator.setPower(0.0);
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
            //telemetry.addData("topSpin:", "pos=%d, power=%.2f", get_topSpin_motor_enc(), topSpin.getPower());
            telemetry.addData("actuator:", "pos=%d, power=%.2f", get_actuator_motor_enc(), actuator.getPower());
        }
//            if (DEBUG) telemetry.addData("Forward 5, then LEFT: ", stage);
 //           super.loop();
    }
}
