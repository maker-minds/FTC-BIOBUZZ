package org.firstinspires.ftc.teamcode.BIOBUZZ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics.DriveTrain;
import org.firstinspires.ftc.teamcode.BIOBUZZ.mechanics.Intake;

@TeleOp(name = "OpMode_Agents", group = "BIOBUZZ")
public class OpModeAgents extends OpMode {

    //---Systems---\\
    private DriveTrain drivetrain = new DriveTrain();
    private Intake intake = new Intake();

    //---Constants---\\
    private enum Modi {
        INPUT,
        OUTPUT
    }

    //---Variables---\\
    private Modi modus = Modi.INPUT;
    public static byte storedItems = 0;

    //---Functions---\\
    @Override
    public void init() {
        drivetrain.init(hardwareMap);
        drivetrain.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        drivetrain.setZeroPowerBehaviour(DcMotor.ZeroPowerBehavior.FLOAT);
        intake.init(hardwareMap);
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
            intake.activate();
        } else if(modus == Modi.OUTPUT) {
            intake.deactivate();
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
