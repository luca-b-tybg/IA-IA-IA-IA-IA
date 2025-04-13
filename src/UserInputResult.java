public class UserInputResult {
    private final KeyFile.Key key;
    private final ModeFile.Mode mode;
    private final CadenceFile.Cadence cadence;
    private final ChordTypeFile.ChordType chordType;

    public UserInputResult(KeyFile.Key key, ModeFile.Mode mode, CadenceFile.Cadence cadence, ChordTypeFile.ChordType chordType) {
        this.key = key;
        this.mode = mode;
        this.cadence = cadence;
        this.chordType = chordType;
    }

    public KeyFile.Key getKey() {
        return key;
    }

    public ModeFile.Mode getMode() {
        return mode;
    }

    public CadenceFile.Cadence getCadence() {
        return cadence;
    }

    public ChordTypeFile.ChordType getChordType() {
        return chordType;
    }

}
