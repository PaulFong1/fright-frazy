package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

// Created  for 16887.
@Autonomous(name="Spin Test", group="Simple")
//@Disabled
public class SpinTest extends BaseRobot {
    private int stage = 0;

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
        if (time<4.5) {
            topSpin.setPower(0.2);
            //reset_drive_encoders();
        } else if (time <10.0) {
            topSpin.setPower(-0.2);
            //reset_drive_encoders();
        } else if (time <15.0) {
            topSpin.setPower(0.5);
        } else if (time<20.0) {
            topSpin.setPower(-0.5);
        } else if (time<25.0) {
            topSpin.setPower(0.75);
        } else
            topSpin.setPower(0.0);
        if (DEBUG) {
            telemetry.addData("Front curr pos:", "Left=%d, Right=%d", get_leftFront_motor_enc(), get_rightFront_motor_enc());
            telemetry.addData("Back  curr pos:", "Left=%d, Right=%d", get_leftBack_motor_enc(), get_rightBack_motor_enc());
            telemetry.addData("Front power: ", "Left=%.2f, Right=%.2f", leftFront.getPower(), rightFront.getPower());
            telemetry.addData("Back  power: ", "Left=%.2f, Right=%.2f", leftBack.getPower(), rightBack.getPower());
            telemetry.addData("linearSlide:", "pos=%d, power=%.2f", get_linearSlide_motor_enc(), linearSlide.getPower());
            telemetry.addData("topSpin:", "pos=%d, power=%.2f", get_topSpin_motor_enc(), topSpin.getPower());
            telemetry.addData("rotate1:", "pos=%d, power=%.2f", get_rotate1_motor_enc(), rotate1.getPower());
        }
    }
}
