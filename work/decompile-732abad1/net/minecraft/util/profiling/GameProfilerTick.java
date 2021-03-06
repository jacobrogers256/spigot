package net.minecraft.util.profiling;

import com.mojang.logging.LogUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.LongSupplier;
import javax.annotation.Nullable;
import org.slf4j.Logger;

public class GameProfilerTick {

    private static final Logger LOGGER = LogUtils.getLogger();
    private final LongSupplier realTime;
    private final long saveThreshold;
    private int tick;
    private final File location;
    private GameProfilerFillerActive profiler;

    public GameProfilerTick(LongSupplier longsupplier, String s, long i) {
        this.profiler = GameProfilerDisabled.INSTANCE;
        this.realTime = longsupplier;
        this.location = new File("debug", s);
        this.saveThreshold = i;
    }

    public GameProfilerFiller startTick() {
        this.profiler = new MethodProfiler(this.realTime, () -> {
            return this.tick;
        }, false);
        ++this.tick;
        return this.profiler;
    }

    public void endTick() {
        if (this.profiler != GameProfilerDisabled.INSTANCE) {
            MethodProfilerResults methodprofilerresults = this.profiler.getResults();

            this.profiler = GameProfilerDisabled.INSTANCE;
            if (methodprofilerresults.getNanoDuration() >= this.saveThreshold) {
                File file = this.location;
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
                Date date = new Date();
                File file1 = new File(file, "tick-results-" + simpledateformat.format(date) + ".txt");

                methodprofilerresults.saveResults(file1.toPath());
                GameProfilerTick.LOGGER.info("Recorded long tick -- wrote info to: {}", file1.getAbsolutePath());
            }

        }
    }

    @Nullable
    public static GameProfilerTick createTickProfiler(String s) {
        return null;
    }

    public static GameProfilerFiller decorateFiller(GameProfilerFiller gameprofilerfiller, @Nullable GameProfilerTick gameprofilertick) {
        return gameprofilertick != null ? GameProfilerFiller.tee(gameprofilertick.startTick(), gameprofilerfiller) : gameprofilerfiller;
    }
}
