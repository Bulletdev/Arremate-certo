/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.SoundCard;
/*     */ import oshi.hardware.common.AbstractSoundCard;
/*     */ import oshi.util.ExecutingCommand;
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
/*     */ 
/*     */ @Immutable
/*     */ final class OpenBsdSoundCard
/*     */   extends AbstractSoundCard
/*     */ {
/*  47 */   private static final Pattern AUDIO_AT = Pattern.compile("audio\\d+ at (.+)");
/*     */   
/*  49 */   private static final Pattern PCI_AT = Pattern.compile("(.+) at pci\\d+ dev \\d+ function \\d+ \"(.*)\" (rev .+):.*");
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
/*     */   OpenBsdSoundCard(String paramString1, String paramString2, String paramString3) {
/*  62 */     super(paramString1, paramString2, paramString3);
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
/*  73 */     List list = ExecutingCommand.runNative("dmesg");
/*     */     
/*  75 */     HashSet<String> hashSet = new HashSet();
/*  76 */     for (String str1 : list) {
/*  77 */       Matcher matcher = AUDIO_AT.matcher(str1);
/*  78 */       if (matcher.matches()) {
/*  79 */         hashSet.add(matcher.group(1));
/*     */       }
/*     */     } 
/*     */     
/*  83 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  84 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  85 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/*  86 */     String str = "";
/*  87 */     for (String str1 : list) {
/*  88 */       Matcher matcher = PCI_AT.matcher(str1);
/*  89 */       if (matcher.matches() && hashSet.contains(matcher.group(1))) {
/*  90 */         str = matcher.group(1);
/*  91 */         hashMap1.put(str, matcher.group(2));
/*  92 */         hashMap3.put(str, matcher.group(3)); continue;
/*  93 */       }  if (!str.isEmpty()) {
/*     */         
/*  95 */         int i = str1.indexOf("codec");
/*  96 */         if (i >= 0) {
/*  97 */           i = str1.indexOf(':');
/*  98 */           hashMap2.put(str, str1.substring(i + 1).trim());
/*     */         } 
/*     */         
/* 101 */         str = "";
/*     */       } 
/*     */     } 
/* 104 */     ArrayList<OpenBsdSoundCard> arrayList = new ArrayList();
/* 105 */     for (Map.Entry<Object, Object> entry : hashMap1.entrySet()) {
/* 106 */       arrayList.add(new OpenBsdSoundCard((String)hashMap3.get(entry.getKey()), (String)entry.getValue(), (String)hashMap2
/* 107 */             .get(entry.getKey())));
/*     */     }
/* 109 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdSoundCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */