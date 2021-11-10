package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// Created for 16887.
@TeleOp(name = "Main TeleOp", group = "TeleOp")
//@Disabled
public class MainTeleOp extends BaseRobot {
    private int stage = 0;
    private int firstLevel = 0;
    private int secondLevel = 200;
    private int thirdLevel = 800;
    private boolean turned = false;
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void start() {
        super.start();

    }

    @Override
    public void loop() {
        //     reset_drive_encoders();
        //    reset_linearSlide_encoders();
        //    reset_rotate_encoders();
        //     reset_spin_encoders();
        //        tankanum_original(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);
        // tankanum_drive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);


        tank_drive(gamepad1.left_stick_y, gamepad1.right_stick_y);

        // Mini movements
        //    if ((gamepad1.right_stick_y == 0) && (gamepad1.left_stick_y == 0) && (gamepad1.right_stick_x == 0)) {
        //          if (gamepad1.dpad_up) auto_drive(0.75, 0.5);
        //       else if (gamepad1.dpad_down) auto_drive(-0.75, 0.5);


        //     }

        if (gamepad1.left_bumper)
            box_Spin.setPosition(0.5);
        if (gamepad1.right_bumper)
            box_Spin.setPosition(0);
 /*
        if (gamepad1.left_bumper)
            if (turned)
            {
                box_Spin.setPosition(box_Spin.getPosition() - 0.5);
                telemetry.addData("tilt direction: ","=%.2f", box_Spin.getPosition());
            }
            else {
                box_Spin.setPosition(box_Spin.getPosition() + 0.5);
                turned = true;
                }


  */

       if (gamepad1.a)
            axle_spin.setPower(0.7);
       else if (gamepad1.b)
            axle_spin.setPower(-0.7);
       else
           axle_spin.setPower(0);


        if (get_linearSlide_motor_enc() < secondLevel - 100) stage = 0;
        else if (get_linearSlide_motor_enc() < thirdLevel - 100) stage = 1;
        else stage = 2;

//        telemetry.addData("lift enc: ", "=%.2f", linearSlide.getCurrentPosition());
//        telemetry.addData("stage: ", "=%d",stage);
        telemetry.update();

        if (gamepad1.x && stage < 2) {
            linearSlideSetPosition(linearSlide, stage == 0 ? secondLevel : thirdLevel);
            stage++;
        } else if (gamepad1.y && stage > 0) {
            linearSlideSetPosition(linearSlide, stage == 2 ? secondLevel : firstLevel);
            stage--;
        } else if (gamepad1.dpad_right) {
            linearSlide.setPower(0.8);
            if (linearSlide.getCurrentPosition() >= secondLevel) {
                stage = 1;
            }
            if (linearSlide.getCurrentPosition() >= thirdLevel) {
                stage = 2;
            }
        } else if (gamepad1.dpad_left) {
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

        if (gamepad1.left_trigger > 0.5)
            topSpin.setPower(0.7);
        else
            topSpin.setPower(0);
        if (gamepad1.right_trigger>0.5)
            topSpin.setPower(-0.7);
        else topSpin.setPower(0);


        if (gamepad1.dpad_down)
            rotate1.setPower(-0.5);

         else if (gamepad1.dpad_up)
            rotate1.setPower(0.7);

        else
            rotate1.setPower(0);

            if (gamepad1.left_stick_button) DEBUG = !DEBUG; // Toggle the debug flag
        super.loop();



        }

    }

