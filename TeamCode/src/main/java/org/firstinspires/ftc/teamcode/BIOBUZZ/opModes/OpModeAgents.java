package org.firstinspires.ftc.teamcode.BIOBUZZ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics.DriveTrain;
@TeleOp(name = "OpMode_Agents", group = "BIOBUZZ")
public class OpModeAgents extends OpMode {

    //---Systems---\\
    DriveTrain drivetrain = new DriveTrain();

    //---Constants---\\
    private enum Modi {
        INPUT,
        OUTPUT
    }

    //---Variables---\\
    Modi modus = Modi.INPUT;

    @Override
    public void init() {
        drivetrain.init(hardwareMap);
        drivetrain.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drivetrain.setZeroPowerBehaviour(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {
        getSensoryInput();
        drive();
        if(modus == Modi.INPUT) {

        } else if(modus == Modi.OUTPUT) {

        }
    }

    private void getSensoryInput() {

    }

    private void drive() {
        double drive, turn, drift;
        drive = gamepad1.left_stick_y;
        turn = gamepad1.right_stick_x;
        drift = gamepad1.left_stick_x;
        double leftfront = drive + turn + drift;
        double leftback = drive + turn - drift;
        double rightfront = drive - turn - drift;
        double rightback = drive - turn + drift;
        drivetrain.setPower(leftfront, rightfront, leftback, rightback);
    }
}
