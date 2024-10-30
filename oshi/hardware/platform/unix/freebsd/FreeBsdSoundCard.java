/*    */ package oshi.hardware.platform.unix.freebsd;
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
/*    */ final class FreeBsdSoundCard
/*    */   extends AbstractSoundCard
/*    */ {
/*    */   private static final String LSHAL = "lshal";
/*    */   
/*    */   FreeBsdSoundCard(String paramString1, String paramString2, String paramString3) {
/* 56 */     super(paramString1, paramString2, paramString3);
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
/* 67 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/* 68 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 69 */     hashMap1.clear();
/* 70 */     hashMap2.clear();
/* 71 */     ArrayList<String> arrayList = new ArrayList();
/* 72 */     String str = "";
/* 73 */     for (String str1 : ExecutingCommand.runNative("lshal")) {
/* 74 */       str1 = str1.trim();
/* 75 */       if (str1.startsWith("udi =")) {
/*    */         
/* 77 */         str = ParseUtil.getSingleQuoteStringValue(str1); continue;
/* 78 */       }  if (!str.isEmpty() && !str1.isEmpty()) {
/* 79 */         if (str1.contains("freebsd.driver =") && "pcm".equals(ParseUtil.getSingleQuoteStringValue(str1))) {
/* 80 */           arrayList.add(str); continue;
/* 81 */         }  if (str1.contains("info.product")) {
/* 82 */           hashMap2.put(str, ParseUtil.getStringBetween(str1, '\'')); continue;
/* 83 */         }  if (str1.contains("info.vendor")) {
/* 84 */           hashMap1.put(str, ParseUtil.getStringBetween(str1, '\''));
/*    */         }
/*    */       } 
/*    */     } 
/* 88 */     ArrayList<FreeBsdSoundCard> arrayList1 = new ArrayList();
/* 89 */     for (String str1 : arrayList) {
/* 90 */       arrayList1.add(new FreeBsdSoundCard((String)hashMap2.get(str1), (String)hashMap1.get(str1) + " " + (String)hashMap2.get(str1), (String)hashMap2
/* 91 */             .get(str1)));
/*    */     }
/* 93 */     return (List)arrayList1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdSoundCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */