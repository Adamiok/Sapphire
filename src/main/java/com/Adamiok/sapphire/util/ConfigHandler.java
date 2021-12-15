package com.Adamiok.sapphire.util;

import java.nio.file.Path;

import com.Adamiok.sapphire.core.config.OreGenConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

//This class creates the Config File to be customized
@Mod.EventBusSubscriber
public class ConfigHandler
{
  public static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
  public static ForgeConfigSpec COMMON_CONFIG;

  static
  {
      //Config classes
      OreGenConfig.Init(COMMON_BUILDER);


      COMMON_CONFIG = COMMON_BUILDER.build();
  }

  //Load config function and settings
  public static void loadConfig(ForgeConfigSpec spec, Path file)
  {
      final CommentedFileConfig configData = CommentedFileConfig.builder(file)
              .sync()
              .autosave()
              .autoreload()
              .writingMode(WritingMode.REPLACE)
              .build();

      configData.load();
      spec.setConfig(configData);
  }

}