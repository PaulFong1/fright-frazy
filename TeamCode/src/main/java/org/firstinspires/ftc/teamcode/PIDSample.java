/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.BaseRobot;
import org.firstinspires.ftc.teamcode.Control;
/*import org.firstinspires.ftc.teamcode.hardware.Control;
import org.firstinspires.ftc.teamcode.hardware.Devices;
import org.firstinspires.ftc.teamcode.hardware.Encoders;*/

/*import static org.firstinspires.ftc.teamcode.hardware.ConstantVariables.K_P;
import static org.firstinspires.ftc.teamcode.hardware.Devices.armLiftMotor1;
import static org.firstinspires.ftc.teamcode.hardware.Devices.armLiftMotor2;

@TeleOp
public class PidSample extends BaseRobot {
    Control.pid armController;
    double currentAngle;
    double output;

    double p=.03;
    double p1=0;
    double i=0;
    double d=0.05;
    public void init() {
        super.init();
        armController  = new Control.pid(0.1);
        resetMotorEnc(rotate1);

    }

    public static void resetMotorEnc(DcMotor motor)
    {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public static double armEncoderToAngle(double encoderReading) {
        return encoderReading/100 * 360*0.5;
    }
    public void loop() {
        super.loop();

        currentAngle = armEncoderToAngle(rotate1.getCurrentPosition());

        if(gamepad1.dpad_up) {
            if (currentAngle<70)

                output = armController.getPower(60, (currentAngle), p, i, d);
            else
                output = armController.getPower(60, currentAngle, p1, i, d);
        } else if (gamepad1.dpad_down) {
            output = armController.getPower(0, currentAngle, p1, i, d);
        }

        else if (gamepad1.triangle) {
            output = 0.1;
        } else if (gamepad1.cross) {
            output = -0.1;
        }

        else {
            output = 0;
        }

        Range.clip(output,-1,1);
        rotate1.setPower(output);


        if(gamepad1.circle) {
            resetMotorEnc(rotate1);

        }

        if (gamepad1.dpad_right) {
            p1+=.0001;
        } else if (gamepad1.dpad_left) {
            p1-=.0001;
        }

        telemetry.addData("p: ", p);
        telemetry.addData("p1: ", p1);
        telemetry.addData("i: ", i);
        telemetry.addData("d: ", d);
        telemetry.addData("arm 1 angle: ", armEncoderToAngle(rotate1.getCurrentPosition()));

        telemetry.addData("output: ", output);
    }
}*/
