package org.firstinspires.ftc.teamcode.Auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.BaseRobot;

// Created  for 16887.
@Autonomous(name="BlueParkTest", group="Simple")
//@Disabled
public class BluePark extends BaseRobot {
    private int step = 1;

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
        switch (step) {
            case 1:
                auto_drive(0.5, 30);
                step++;
                break;
            case 2:
                auto_turn(-0.5, 45);
                step++;
                break;
            case 3:
                auto_drive(0.5,5);
                step++;
                break;
            case 4:
                axle_Spin.setPower(-0.7);
                auto_drive(0.1,9);

                step++;
                break;
            case 5:
                axle_Spin.setPower(0);
                auto_turn(0.5, 45);
                step++;
                break;
            case 6:
                auto_turn(-0.5,95);//-
                step++;

                break;

            case 7:
                auto_drive(-0.5, 30);//-
                //step++;
                break;


            default: break;

        }
      //  auto_mecanum(-0.5,100);
        /*
        if (time<1.4) {
          //  tank_drive(-0.4,-0.4);
            //      auto_drive(-0.3, 5);
            //   actuator.setPower(-0.3);
        }
        else if (time>1.6 && time<2.9)
        {
           tank_drive(-0.1,-0.6);
        }
        else if (time>3.0 && time<5)
            tank_drive(-0.5,-0.5);
        //else if (time<5.1 && time>3.0)
          //  auto_turn(-0.5,7);
        //else if (time>5.1 && time <5.5) {
         //   topSpin.setPower(-0.5);
            //  actuator.setPower(-0.5);
       // }

        //else if (time<6.2 && time > 5.5)
        //{
          //  tank_drive(-0.2,-0.2);
        //}
        else
        {

            tank_drive(0.0,0.0);
            topSpin.setPower(0);
            return;

        }
    /*    switch (step) {
            case 0:         auto_drive(-0.3, 27);
                step++;
                break;
            case 1: if (time<120)
                topSpin.setPower(0.7);   //   auto_drive(-0.3, 12);
                step++;
                break;
            case 2:   topSpin.setPower(0);
                auto_turn(-0.3, 180);
                step++;
                break;
           case 3:      //  auto_drive(0.5, 60);
            //    step++;
                break;

            default: break;
        }

     */

        if (DEBUG) {
            telemetry.addData("Front curr pos:", "Left=%d, Right=%d", get_leftFront_motor_enc(), get_rightFront_motor_enc());
            telemetry.addData("Back  curr pos:", "Left=%d, Right=%d", get_leftBack_motor_enc(), get_rightBack_motor_enc());
            telemetry.addData("Front power: ", "Left=%.2f, Right=%.2f", leftFront.getPower(), rightFront.getPower());
            telemetry.addData("Back  power: ", "Left=%.2f, Right=%.2f", leftBack.getPower(), rightBack.getPower());
            telemetry.addData("linearSlide:", "pos=%d, power=%.2f", get_linearSlide_motor_enc(), linearSlide.getPower());
           // telemetry.addData("topSpin:", "pos=%d, power=%.2f", get_topSpin_motor_enc(), topSpin.getPower());
            telemetry.addData("actuator:", "pos=%d, power=%.2f", get_actuator_motor_enc(), actuator.getPower());
        }
    }
}
