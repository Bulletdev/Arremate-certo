/*    */ package oshi.hardware.platform.unix.solaris;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.Immutable;
/*    */ import oshi.hardware.SoundCard;
/*    */ import oshi.hardware.common.AbstractSoundCard;
/*    */ import oshi.util.ExecutingCommand;
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
/*    */ 
/*    */ @Immutable
/*    */ final class SolarisSoundCard
/*    */   extends AbstractSoundCard
/*    */ {
/*    */   private static final String LSHAL = "lshal";
/*    */   private static final String DEFAULT_AUDIO_DRIVER = "audio810";
/*    */   
/*    */   SolarisSoundCard(String paramString1, String paramString2, String paramString3) {
/* 57 */     super(paramString1, paramString2, paramString3);
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
/* 68 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/* 69 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 70 */     ArrayList<String> arrayList = new ArrayList();
/* 71 */     String str = "";
/* 72 */     for (String str1 : ExecutingCommand.runNative("lshal")) {
/* 73 */       str1 = str1.trim();
/* 74 */       if (str1.startsWith("udi =")) {
/*    */         
/* 76 */         str = ParseUtil.getSingleQuoteStringValue(str1); continue;
/* 77 */       }  if (!str.isEmpty() && !str1.isEmpty()) {
/* 78 */         if (str1.contains("info.solaris.driver =") && "audio810"
/* 79 */           .equals(ParseUtil.getSingleQuoteStringValue(str1))) {
/* 80 */           arrayList.add(str); continue;
/* 81 */         }  if (str1.contains("info.product")) {
/* 82 */           hashMap2.put(str, ParseUtil.getStringBetween(str1, '\'')); continue;
/* 83 */         }  if (str1.contains("info.vendor")) {
/* 84 */           hashMap1.put(str, ParseUtil.getStringBetween(str1, '\''));
/*    */         }
/*    */       } 
/*    */     } 
/* 88 */     ArrayList<SolarisSoundCard> arrayList1 = new ArrayList();
/* 89 */     for (String str1 : arrayList) {
/* 90 */       arrayList1.add(new SolarisSoundCard((String)hashMap2.get(str1) + " " + "audio810", (String)hashMap1
/* 91 */             .get(str1) + " " + (String)hashMap2.get(str1), (String)hashMap2.get(str1)));
/*    */     }
/* 93 */     return (List)arrayList1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisSoundCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */