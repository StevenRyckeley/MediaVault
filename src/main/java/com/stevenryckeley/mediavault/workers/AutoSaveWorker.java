package main.java.com.stevenryckeley.mediavault.workers;

import main.java.com.stevenryckeley.mediavault.vault.Vault;
import main.java.com.stevenryckeley.mediavault.io.VaultSerializer;
import javax.swing.*;
import java.io.IOException;

public class AutoSaveWorker implements Runnable {
    private final Vault vault;
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(60_000);
                VaultSerializer.save(vault, "autosave.vault");
                SwingUtilities.invokeLater(() -> statusBar.setText("Auto-svaed."));
            } catch (InterruptedException e) { running = false;}
              catch (IOException e) { /*log, don't crash */}
        }
    }
}
