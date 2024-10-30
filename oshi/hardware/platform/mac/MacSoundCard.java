/*    */ package oshi.hardware.platform.mac;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.SoundCard;
/*    */ import oshi.hardware.common.AbstractSoundCard;
/*    */ import oshi.util.FileUtil;
/*    */ import oshi.util.ParseUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Immutable
/*    */ final class MacSoundCard
/*    */   extends AbstractSoundCard
/*    */ {
/*    */   private static final String APPLE = "Apple Inc.";
/*    */   
/*    */   MacSoundCard(String paramString1, String paramString2, String paramString3) {
/* 54 */     super(paramString1, paramString2, paramString3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<SoundCard> getSoundCards() {
/* 65 */     ArrayList<MacSoundCard> arrayList = new ArrayList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 74 */     String str1 = "Apple Inc.";
/* 75 */     String str2 = "AppleHDAController";
/* 76 */     String str3 = "AppleHDACodec";
/*    */     
/* 78 */     boolean bool = false;
/* 79 */     String str4 = "<key>com.apple.driver.AppleHDAController</key>";
/*    */ 
/*    */     
/* 82 */     for (String str : FileUtil.readFile("/System/Library/Extensions/AppleHDA.kext/Contents/Info.plist")) {
/* 83 */       if (str.contains(str4)) {
/* 84 */         bool = true;
/*    */         continue;
/*    */       } 
/* 87 */       if (bool) {
/*    */         
/* 89 */         str2 = "AppleHDAController " + ParseUtil.getTextBetweenStrings(str, "<string>", "</string>");
/* 90 */         bool = false;
/*    */       } 
/*    */     } 
/* 93 */     arrayList.add(new MacSoundCard(str2, str1, str3));
/*    */     
/* 95 */     return (List)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacSoundCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */