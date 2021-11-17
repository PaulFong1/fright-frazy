package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// Created for 16887.
@TeleOp(name = "Test TeleOp", group = "TeleOp")
//@Disabled
public class TestTeleOp extends BaseRobot {
    private int stage = 0;
    private int firstLevel = 0;
    private int secondLevel = 200;
    private int thirdLevel = 800;
    private int rot1holdpos = 0;   // The target position for the rotate
    // rotate1 may oscillate around this value
    // Encoder values are not very accurate
    //  private boolean turned = false;

    @Override
    public void init() {

        super.init();
    }

    @Override
    public void start() {
        super.start();

        // axle_spin.resetDeviceConfigurationForOpMode();
/*
        rotate1.setTargetPosition(100);
        rotate1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rotate1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rotate1.setPower(0);
        rotate1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



 */



        //    rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void loop() {
        tankanum_drive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);
        if (gamepad1.right_bumper)
            tankanum_original(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);
        telemetry.addData("rotate1:", "pos=%d, power=%.2f, zero=%s, tar=%d", rotate1.getCurrentPosition(), rotate1.getPower(), rotate1.getZeroPowerBehavior(), rotate1.getTargetPosition());
        //     reset_drive_encoders();
        //    reset_linearSlide_encoders();
        //    reset_rotate_encoders();
        //     reset_spin_encoders();
        //tankanum_original(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);
         tankanum_drive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);


       /* tank_drive(gamepad2.left_stick_y, gamepad2.right_stick_y);
        if (gamepad2.left_bumper)
        {
            topSpin.setPower(0.5);
        }
        else if (gamepad2.right_bumper)
        {
            topSpin.setPower(-0.5);
        }

        else {
            topSpin.setPower(0);
        }*/

        if (gamepad2.left_trigger > 0.2)
            topSpin.setPower(gamepad1.left_trigger);

        else if (gamepad2.right_trigger>0.2)
            topSpin.setPower(-1*gamepad1.right_trigger);
        else topSpin.setPower(0);
        rotate1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //    rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Mini movements
        //    if ((gamepad1.right_stick_y == 0) && (gamepad1.left_stick_y == 0) && (gamepad1.right_stick_x == 0)) {
        //          if (gamepad1.dpad_up) auto_drive(0.75, 0.5);
        //       else if (gamepad1.dpad_down) auto_drive(-0.75, 0.5);


        //     }

        if (gamepad1.left_bumper)
            box_Spin.setPosition(0.4);

        else if (gamepad1.right_bumper)
            box_Spin.setPosition(0.1);




        if (gamepad1.a)
            axle_Spin.setPower(1.0);
        else if (gamepad1.b)
            axle_Spin.setPower(-1.0);
        else
            axle_Spin.setPower(0);


        if (get_linearSlide_motor_enc() < secondLevel - 100) stage = 0;
        else if (get_linearSlide_motor_enc() < thirdLevel - 100) stage = 1;
        else stage = 2;

//        telemetry.addData("lift enc: ", "=%.2f", linearSlide.getCurrentPosition());
//        telemetry.addData("stage: ", "=%d",stage);
        telemetry.update();

        if (gamepad1.x && stage < 2) {
            linearSlideSetPosition(linearSlide, stage == 0 ? secondLevel : thirdLevel);
            stage++;
        }

        else if (gamepad1.y && stage > 0) {
            linearSlideSetPosition(linearSlide, stage == 2 ? secondLevel : firstLevel);
            stage--;
        }

        else if (gamepad1.dpad_right) {
            linearSlide.setPower(0.7);
            if (linearSlide.getCurrentPosition() >= secondLevel) {
                stage = 1;
            }
            if (linearSlide.getCurrentPosition() >= thirdLevel) {
                stage = 2;
            }
        }

        else if (gamepad1.dpad_left) {
            linearSlide.setPower(-0.1);
            if (linearSlide.getCurrentPosition() <= secondLevel) {
                stage = 1;
            }
            if (linearSlide.getCurrentPosition() <= firstLevel) {
                stage = 0;
            }
        } else linearSlide.setPower(0);

        linearSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //turn the motor for the linear slide
//        if (gamepad1.a) linearSlide.setPower(1.0); //extend
//        else if (gamepad1.b) linearSlide.setPower(-1.0); //retract
//
//        else if (gamepad1.x) {
//            if (stage < 2 && get_linearSlide_motor_enc() < 510) {
//                stage++;
//                linearSlideSetPosition(linearSlide, stage, 0.3);
//            }
//        } else if (gamepad1.y) {
//            if (stage > 0 && get_linearSlide_motor_enc() > 490) {
//                stage--;
//                linearSlideSetPosition(linearSlide, stage, 0.3);
//            }
//
//        } else linearSlide.setPower(0);



        if (gamepad1.dpad_up) {
// Don't know if RUN_TO_POSITION is better than BRAKE
//            rotate1.setPower(-1);
//            rot1holdpos = rotate1.getCurrentPosition() - 1;  // Each press move the rotate up 10 pos
            rot1holdpos -= 7;  // Each press move the rotate up 10 pos
            rotate1.setTargetPosition(rot1holdpos);
            rotate1.setPower(-1.0);                           // maximum power to move up and hold
            rotate1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            while (rotate1.isBusy()) { }        // May cause loop problem
            //rotate2.setPower(0.1);
        }
        else if (gamepad1.dpad_down) {
//            rotate1.setPower(0.3);
//            rot1holdpos = rotate1.getCurrentPosition() + 1;
            rot1holdpos += 5;
            rotate1.setTargetPosition(rot1holdpos);
            rotate1.setPower(0.5);
            rotate1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            while (rotate1.isBusy()) { }
            // rotate2.setPower(0.5);

            // else if (get_rotate1_motor_enc()>=200)
            //     rotate1.setPower(-0.4);
            // else if (get_rotate1_motor_enc()>=100)
            //      rotate1.setPower(-0.3);
        }

        else {
            rotate1.setTargetPosition(rot1holdpos);        // Try to stabilize
            rotate1.setPower(-1.0);                        // Need maximize the hold the position
            rotate1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            while (rotate1.isBusy()) { }
            //    rotate1.setPower(0.0);
            //     rotate1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


            //  rotate2.setPower(0.0);

            //rotate2.setPower(0.05);
            //     rotate2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        }


        if (gamepad1.left_stick_button) DEBUG = !DEBUG; // Toggle the debug flag
        super.loop();



    }

}

