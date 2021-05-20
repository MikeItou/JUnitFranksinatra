package tests;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SongSuite {
    @Test
    @FileParameters("./data/IncorrectLogin.csv")
    public void createNewSong(){

    }
}
