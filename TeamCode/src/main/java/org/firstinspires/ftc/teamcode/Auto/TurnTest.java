package org.firstinspires.ftc.teamcode.auto;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.BaseRobot;

// Created  for 16887.
@Autonomous(name="Turn Test", group="Simple")
//@Disabled
public class TurnTest extends BaseRobot {
    private int stage = 0;

    @Override
    public void init() {
        super.init();
        telemetry.addData ("stage",stage);
        DEBUG = true;
    }
    @Override
    public void start() {

        super.start();

    }
    @Override
    public void loop() {
        telemetry.addData ("stage",stage);
        switch (stage) {
            case 0: auto_turn(0.5, 45);
                telemetry.addData ("stage",stage);
                stage++;
                break;
            case 1: auto_turn(-0.5, 45);
                telemetry.addData ("stage",stage);
                stage++;
                break;
            case 2: auto_turn(0.5, 90);
                telemetry.addData ("stage",stage);
                stage++;
                break;
            case 3: auto_turn(-0.5, 90);
                telemetry.addData ("stage",stage);
                stage++;
                break;
//            case 1: auto_drive(0.5, 1);
//              break;
            default: break;
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
    }
}
