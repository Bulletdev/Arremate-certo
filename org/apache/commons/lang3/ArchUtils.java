/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Stream;
/*     */ import org.apache.commons.lang3.arch.Processor;
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
/*     */ 
/*     */ public class ArchUtils
/*     */ {
/*  39 */   private static final Map<String, Processor> ARCH_TO_PROCESSOR = new HashMap<>(); static {
/*  40 */     init();
/*     */   }
/*     */   
/*     */   private static void init() {
/*  44 */     init_X86_32Bit();
/*  45 */     init_X86_64Bit();
/*  46 */     init_IA64_32Bit();
/*  47 */     init_IA64_64Bit();
/*  48 */     init_PPC_32Bit();
/*  49 */     init_PPC_64Bit();
/*     */   }
/*     */   
/*     */   private static void init_X86_32Bit() {
/*  53 */     Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.X86);
/*  54 */     addProcessors(processor, new String[] { "x86", "i386", "i486", "i586", "i686", "pentium" });
/*     */   }
/*     */   
/*     */   private static void init_X86_64Bit() {
/*  58 */     Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.X86);
/*  59 */     addProcessors(processor, new String[] { "x86_64", "amd64", "em64t", "universal" });
/*     */   }
/*     */   
/*     */   private static void init_IA64_32Bit() {
/*  63 */     Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.IA_64);
/*  64 */     addProcessors(processor, new String[] { "ia64_32", "ia64n" });
/*     */   }
/*     */   
/*     */   private static void init_IA64_64Bit() {
/*  68 */     Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.IA_64);
/*  69 */     addProcessors(processor, new String[] { "ia64", "ia64w" });
/*     */   }
/*     */   
/*     */   private static void init_PPC_32Bit() {
/*  73 */     Processor processor = new Processor(Processor.Arch.BIT_32, Processor.Type.PPC);
/*  74 */     addProcessors(processor, new String[] { "ppc", "power", "powerpc", "power_pc", "power_rs" });
/*     */   }
/*     */   
/*     */   private static void init_PPC_64Bit() {
/*  78 */     Processor processor = new Processor(Processor.Arch.BIT_64, Processor.Type.PPC);
/*  79 */     addProcessors(processor, new String[] { "ppc64", "power64", "powerpc64", "power_pc64", "power_rs64" });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void addProcessor(String paramString, Processor paramProcessor) {
/*  90 */     if (ARCH_TO_PROCESSOR.containsKey(paramString)) {
/*  91 */       throw new IllegalStateException("Key " + paramString + " already exists in processor map");
/*     */     }
/*  93 */     ARCH_TO_PROCESSOR.put(paramString, paramProcessor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void addProcessors(Processor paramProcessor, String... paramVarArgs) {
/* 104 */     Stream.<String>of(paramVarArgs).forEach(paramString -> addProcessor(paramString, paramProcessor));
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
/*     */   public static Processor getProcessor() {
/* 118 */     return getProcessor(SystemUtils.OS_ARCH);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Processor getProcessor(String paramString) {
/* 129 */     return ARCH_TO_PROCESSOR.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\ArchUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */