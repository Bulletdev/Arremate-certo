/*     */ package com.sun.jna.platform.unix.solaris;
/*     */ 
/*     */ import com.sun.jna.Library;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.Union;
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
/*     */ 
/*     */ 
/*     */ public interface LibKstat
/*     */   extends Library
/*     */ {
/*  44 */   public static final LibKstat INSTANCE = (LibKstat)Native.load("kstat", LibKstat.class);
/*     */   
/*     */   public static final byte KSTAT_TYPE_RAW = 0;
/*     */   
/*     */   public static final byte KSTAT_TYPE_NAMED = 1;
/*     */   
/*     */   public static final byte KSTAT_TYPE_INTR = 2;
/*     */   
/*     */   public static final byte KSTAT_TYPE_IO = 3;
/*     */   
/*     */   public static final byte KSTAT_TYPE_TIMER = 4;
/*     */   
/*     */   public static final byte KSTAT_DATA_CHAR = 0;
/*     */   
/*     */   public static final byte KSTAT_DATA_INT32 = 1;
/*     */   
/*     */   public static final byte KSTAT_DATA_UINT32 = 2;
/*     */   
/*     */   public static final byte KSTAT_DATA_INT64 = 3;
/*     */   
/*     */   public static final byte KSTAT_DATA_UINT64 = 4;
/*     */   
/*     */   public static final byte KSTAT_DATA_STRING = 9;
/*     */   
/*     */   public static final int KSTAT_INTR_HARD = 0;
/*     */   
/*     */   public static final int KSTAT_INTR_SOFT = 1;
/*     */   
/*     */   public static final int KSTAT_INTR_WATCHDOG = 2;
/*     */   
/*     */   public static final int KSTAT_INTR_SPURIOUS = 3;
/*     */   
/*     */   public static final int KSTAT_INTR_MULTSVC = 4;
/*     */   
/*     */   public static final int KSTAT_NUM_INTRS = 5;
/*     */   
/*     */   public static final int KSTAT_STRLEN = 31;
/*     */   
/*     */   public static final int EAGAIN = 11;
/*     */ 
/*     */   
/*     */   KstatCtl kstat_open();
/*     */ 
/*     */   
/*     */   int kstat_close(KstatCtl paramKstatCtl);
/*     */ 
/*     */   
/*     */   int kstat_chain_update(KstatCtl paramKstatCtl);
/*     */ 
/*     */   
/*     */   int kstat_read(KstatCtl paramKstatCtl, Kstat paramKstat, Pointer paramPointer);
/*     */ 
/*     */   
/*     */   int kstat_write(KstatCtl paramKstatCtl, Kstat paramKstat, Pointer paramPointer);
/*     */ 
/*     */   
/*     */   Kstat kstat_lookup(KstatCtl paramKstatCtl, String paramString1, int paramInt, String paramString2);
/*     */ 
/*     */   
/*     */   Pointer kstat_data_lookup(Kstat paramKstat, String paramString);
/*     */   
/*     */   @FieldOrder({"ks_crtime", "ks_next", "ks_kid", "ks_module", "ks_resv", "ks_instance", "ks_name", "ks_type", "ks_class", "ks_flags", "ks_data", "ks_ndata", "ks_data_size", "ks_snaptime", "ks_update", "ks_private", "ks_snapshot", "ks_lock"})
/*     */   public static class Kstat
/*     */     extends Structure
/*     */   {
/*     */     public long ks_crtime;
/*     */     public Pointer ks_next;
/*     */     public int ks_kid;
/* 112 */     public byte[] ks_module = new byte[31];
/*     */     
/*     */     public byte ks_resv;
/*     */     
/*     */     public int ks_instance;
/*     */     
/* 118 */     public byte[] ks_name = new byte[31];
/*     */     
/*     */     public byte ks_type;
/*     */     
/* 122 */     public byte[] ks_class = new byte[31];
/*     */     
/*     */     public byte ks_flags;
/*     */     
/*     */     public Pointer ks_data;
/*     */     
/*     */     public int ks_ndata;
/*     */     
/*     */     public long ks_data_size;
/*     */     
/*     */     public long ks_snaptime;
/*     */     
/*     */     public int ks_update;
/*     */     
/*     */     public Pointer ks_private;
/*     */     
/*     */     public int ks_snapshot;
/*     */     
/*     */     public Pointer ks_lock;
/*     */ 
/*     */     
/*     */     public Kstat next() {
/* 144 */       if (this.ks_next == null) {
/* 145 */         return null;
/*     */       }
/* 147 */       Kstat kstat = new Kstat();
/* 148 */       kstat.useMemory(this.ks_next);
/* 149 */       kstat.read();
/* 150 */       return kstat;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"name", "data_type", "value"})
/*     */   public static class KstatNamed
/*     */     extends Structure
/*     */   {
/* 160 */     public byte[] name = new byte[31];
/*     */     public byte data_type;
/*     */     public UNION value;
/*     */     
/*     */     public KstatNamed() {}
/*     */     
/*     */     public static class UNION
/*     */       extends Union {
/* 168 */       public byte[] charc = new byte[16];
/*     */       
/*     */       public int i32;
/*     */       
/*     */       public int ui32;
/*     */       public long i64;
/*     */       public long ui64;
/*     */       public STR str;
/*     */       
/*     */       @FieldOrder({"addr", "len"})
/*     */       public static class STR
/*     */         extends Structure
/*     */       {
/*     */         public Pointer addr;
/*     */         public int len;
/*     */       }
/*     */     }
/*     */     
/*     */     @FieldOrder({"addr", "len"})
/*     */     public static class STR
/*     */       extends Structure
/*     */     {
/*     */       public Pointer addr;
/*     */       public int len;
/*     */     }
/*     */     
/*     */     public KstatNamed(Pointer param1Pointer) {
/* 195 */       super(param1Pointer);
/* 196 */       read();
/*     */     }
/*     */ 
/*     */     
/*     */     public void read() {
/* 201 */       super.read();
/* 202 */       switch (this.data_type) {
/*     */         case 0:
/* 204 */           this.value.setType(byte[].class);
/*     */           break;
/*     */         case 9:
/* 207 */           this.value.setType(UNION.STR.class);
/*     */           break;
/*     */         case 1:
/*     */         case 2:
/* 211 */           this.value.setType(int.class);
/*     */           break;
/*     */         case 3:
/*     */         case 4:
/* 215 */           this.value.setType(long.class);
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 220 */       this.value.read();
/*     */     }
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
/*     */   @FieldOrder({"intrs"})
/*     */   public static class KstatIntr
/*     */     extends Structure
/*     */   {
/* 236 */     public int[] intrs = new int[5];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"name", "resv", "num_events", "elapsed_time", "min_time", "max_time", "start_time", "stop_time"})
/*     */   public static class KstatTimer
/*     */     extends Structure
/*     */   {
/* 248 */     public byte[] name = new byte[31];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public byte resv;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long num_events;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long elapsed_time;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long min_time;
/*     */ 
/*     */ 
/*     */     
/*     */     public long max_time;
/*     */ 
/*     */ 
/*     */     
/*     */     public long start_time;
/*     */ 
/*     */ 
/*     */     
/*     */     public long stop_time;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"nread", "nwritten", "reads", "writes", "wtime", "wlentime", "wlastupdate", "rtime", "rlentime", "rlastupdate", "wcnt", "rcnt"})
/*     */   public static class KstatIO
/*     */     extends Structure
/*     */   {
/*     */     public long nread;
/*     */ 
/*     */ 
/*     */     
/*     */     public long nwritten;
/*     */ 
/*     */ 
/*     */     
/*     */     public int reads;
/*     */ 
/*     */ 
/*     */     
/*     */     public int writes;
/*     */ 
/*     */ 
/*     */     
/*     */     public long wtime;
/*     */ 
/*     */ 
/*     */     
/*     */     public long wlentime;
/*     */ 
/*     */ 
/*     */     
/*     */     public long wlastupdate;
/*     */ 
/*     */ 
/*     */     
/*     */     public long rtime;
/*     */ 
/*     */ 
/*     */     
/*     */     public long rlentime;
/*     */ 
/*     */ 
/*     */     
/*     */     public long rlastupdate;
/*     */ 
/*     */ 
/*     */     
/*     */     public int wcnt;
/*     */ 
/*     */ 
/*     */     
/*     */     public int rcnt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public KstatIO() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public KstatIO(Pointer param1Pointer) {
/* 345 */       super(param1Pointer);
/* 346 */       read();
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"kc_chain_id", "kc_chain", "kc_kd"})
/*     */   public static class KstatCtl extends Structure {
/*     */     public int kc_chain_id;
/*     */     public LibKstat.Kstat kc_chain;
/*     */     public int kc_kd;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platfor\\unix\solaris\LibKstat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */