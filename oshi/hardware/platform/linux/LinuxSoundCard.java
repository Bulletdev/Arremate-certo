/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.SoundCard;
/*     */ import oshi.hardware.common.AbstractSoundCard;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Immutable
/*     */ final class LinuxSoundCard
/*     */   extends AbstractSoundCard
/*     */ {
/*  46 */   private static final Logger LOG = LoggerFactory.getLogger(LinuxSoundCard.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String CARD_FOLDER = "card";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String CARDS_FILE = "cards";
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String ID_FILE = "id";
/*     */ 
/*     */ 
/*     */   
/*     */   LinuxSoundCard(String paramString1, String paramString2, String paramString3) {
/*  63 */     super(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static List<File> getCardFolders() {
/*  73 */     File file = new File(ProcPath.ASOUND);
/*  74 */     ArrayList<File> arrayList = new ArrayList();
/*  75 */     File[] arrayOfFile = file.listFiles();
/*  76 */     if (arrayOfFile != null) {
/*  77 */       for (File file1 : arrayOfFile) {
/*  78 */         if (file1.getName().startsWith("card") && file1.isDirectory()) {
/*  79 */           arrayList.add(file1);
/*     */         }
/*     */       } 
/*     */     } else {
/*  83 */       LOG.warn("No Audio Cards Found");
/*     */     } 
/*  85 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getSoundCardVersion() {
/*  97 */     String str = FileUtil.getStringFromFile(ProcPath.ASOUND + "version");
/*  98 */     return str.isEmpty() ? "not available" : str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getCardCodec(File paramFile) {
/* 113 */     String str = "";
/* 114 */     File[] arrayOfFile = paramFile.listFiles();
/* 115 */     if (arrayOfFile != null) {
/* 116 */       for (File file : arrayOfFile) {
/* 117 */         if (file.getName().startsWith("codec")) {
/* 118 */           if (!file.isDirectory()) {
/* 119 */             str = (String)FileUtil.getKeyValueMapFromFile(file.getPath(), ":").get("Codec");
/*     */           
/*     */           }
/*     */           else {
/*     */ 
/*     */             
/* 125 */             File[] arrayOfFile1 = file.listFiles();
/* 126 */             if (arrayOfFile1 != null) {
/* 127 */               for (File file1 : arrayOfFile1) {
/* 128 */                 if (!file1.isDirectory() && file1.getName().contains("#")) {
/* 129 */                   str = file1.getName().substring(0, file1.getName().indexOf('#'));
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/* 138 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getCardName(File paramFile) {
/* 155 */     String str1 = "Not Found..";
/* 156 */     Map map = FileUtil.getKeyValueMapFromFile(ProcPath.ASOUND + "/" + "cards", ":");
/* 157 */     String str2 = FileUtil.getStringFromFile(paramFile.getPath() + "/" + "id");
/* 158 */     for (Map.Entry entry : map.entrySet()) {
/* 159 */       if (((String)entry.getKey()).contains(str2)) {
/* 160 */         str1 = (String)entry.getValue();
/* 161 */         return str1;
/*     */       } 
/*     */     } 
/* 164 */     return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<SoundCard> getSoundCards() {
/* 175 */     ArrayList<LinuxSoundCard> arrayList = new ArrayList();
/* 176 */     for (File file : getCardFolders()) {
/* 177 */       arrayList.add(new LinuxSoundCard(getSoundCardVersion(), getCardName(file), getCardCodec(file)));
/*     */     }
/* 179 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxSoundCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */