
package org.firstinspires.ftc.teamcode.BIOBUZZ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class OpModeTest extends OpMode {

    //---Variables---\\
    private String[] options = {"limelight"};
    private int index = 0;

    //---Objects---\\
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        for(String text : options) {
            telemetry.addLine(text);
        }
    }
}
