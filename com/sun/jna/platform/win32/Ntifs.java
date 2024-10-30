/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
/*     */ import com.sun.jna.Union;
/*     */ import com.sun.jna.win32.W32APITypeMapper;
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
/*     */ public interface Ntifs
/*     */   extends BaseTSD, WinDef
/*     */ {
/*     */   public static final int MAXIMUM_REPARSE_DATA_BUFFER_SIZE = 16384;
/*     */   public static final int REPARSE_BUFFER_HEADER_SIZE = 8;
/*     */   public static final int SYMLINK_FLAG_RELATIVE = 1;
/*     */   
/*     */   @FieldOrder({"SubstituteNameOffset", "SubstituteNameLength", "PrintNameOffset", "PrintNameLength", "Flags", "PathBuffer"})
/*     */   public static class SymbolicLinkReparseBuffer
/*     */     extends Structure
/*     */   {
/*     */     public static class ByReference
/*     */       extends SymbolicLinkReparseBuffer
/*     */       implements Structure.ByReference
/*     */     {
/*     */       public ByReference() {}
/*     */       
/*     */       public ByReference(Pointer param2Pointer) {
/*  59 */         super(param2Pointer);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     public short SubstituteNameOffset = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     public short SubstituteNameLength = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     public short PrintNameOffset = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     public short PrintNameLength = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     public int Flags = 0;
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
/* 104 */     public char[] PathBuffer = new char[8192];
/*     */     
/*     */     public static int sizeOf() {
/* 107 */       return Native.getNativeSize(Ntifs.MountPointReparseBuffer.class, null);
/*     */     }
/*     */     
/*     */     public SymbolicLinkReparseBuffer() {
/* 111 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public SymbolicLinkReparseBuffer(Pointer param1Pointer) {
/* 115 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 116 */       read();
/*     */     }
/*     */ 
/*     */     
/*     */     public SymbolicLinkReparseBuffer(String param1String1, String param1String2, int param1Int) {
/* 121 */       String str = param1String1 + param1String2;
/* 122 */       this.PathBuffer = str.toCharArray();
/* 123 */       this.SubstituteNameOffset = 0;
/* 124 */       this.SubstituteNameLength = (short)(param1String1.length() * 2);
/* 125 */       this.PrintNameOffset = (short)(param1String1.length() * 2);
/* 126 */       this.PrintNameLength = (short)(param1String2.length() * 2);
/* 127 */       this.Flags = param1Int;
/* 128 */       write();
/*     */     }
/*     */ 
/*     */     
/*     */     public SymbolicLinkReparseBuffer(short param1Short1, short param1Short2, short param1Short3, short param1Short4, int param1Int, String param1String) {
/* 133 */       this.SubstituteNameOffset = param1Short1;
/* 134 */       this.SubstituteNameLength = param1Short2;
/* 135 */       this.PrintNameOffset = param1Short3;
/* 136 */       this.PrintNameLength = param1Short4;
/* 137 */       this.Flags = param1Int;
/* 138 */       this.PathBuffer = param1String.toCharArray();
/* 139 */       write();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPrintName() {
/* 146 */       return String.copyValueOf(this.PathBuffer, this.PrintNameOffset / 2, this.PrintNameLength / 2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSubstituteName() {
/* 153 */       return String.copyValueOf(this.PathBuffer, this.SubstituteNameOffset / 2, this.SubstituteNameLength / 2);
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"SubstituteNameOffset", "SubstituteNameLength", "PrintNameOffset", "PrintNameLength", "PathBuffer"})
/*     */   public static class MountPointReparseBuffer
/*     */     extends Structure {
/*     */     public static class ByReference
/*     */       extends MountPointReparseBuffer implements Structure.ByReference {
/*     */       public ByReference() {}
/*     */       
/*     */       public ByReference(Pointer param2Pointer) {
/* 165 */         super(param2Pointer);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     public short SubstituteNameOffset = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 179 */     public short SubstituteNameLength = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     public short PrintNameOffset = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     public short PrintNameLength = 0;
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
/* 202 */     public char[] PathBuffer = new char[8192];
/*     */     
/*     */     public static int sizeOf() {
/* 205 */       return Native.getNativeSize(MountPointReparseBuffer.class, null);
/*     */     }
/*     */     
/*     */     public MountPointReparseBuffer() {
/* 209 */       super(W32APITypeMapper.UNICODE);
/*     */     }
/*     */     
/*     */     public MountPointReparseBuffer(Pointer param1Pointer) {
/* 213 */       super(param1Pointer, 0, W32APITypeMapper.UNICODE);
/* 214 */       read();
/*     */     }
/*     */ 
/*     */     
/*     */     public MountPointReparseBuffer(String param1String1, String param1String2) {
/* 219 */       String str = param1String1 + param1String2;
/* 220 */       this.PathBuffer = str.toCharArray();
/* 221 */       this.SubstituteNameOffset = 0;
/* 222 */       this.SubstituteNameLength = (short)param1String1.length();
/* 223 */       this.PrintNameOffset = (short)(param1String1.length() * 2);
/* 224 */       this.PrintNameLength = (short)(param1String2.length() * 2);
/* 225 */       write();
/*     */     }
/*     */ 
/*     */     
/*     */     public MountPointReparseBuffer(short param1Short1, short param1Short2, short param1Short3, short param1Short4, String param1String) {
/* 230 */       this.SubstituteNameOffset = param1Short1;
/* 231 */       this.SubstituteNameLength = param1Short2;
/* 232 */       this.PrintNameOffset = param1Short3;
/* 233 */       this.PrintNameLength = param1Short4;
/* 234 */       this.PathBuffer = param1String.toCharArray();
/* 235 */       write();
/*     */     }
/*     */   }
/*     */   
/*     */   @FieldOrder({"DataBuffer"})
/*     */   public static class GenericReparseBuffer
/*     */     extends Structure {
/*     */     public static class ByReference
/*     */       extends GenericReparseBuffer implements Structure.ByReference {
/*     */       public ByReference() {}
/*     */       
/*     */       public ByReference(Pointer param2Pointer) {
/* 247 */         super(param2Pointer);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     public byte[] DataBuffer = new byte[16384];
/*     */     
/*     */     public static int sizeOf() {
/* 258 */       return Native.getNativeSize(GenericReparseBuffer.class, null);
/*     */     }
/*     */ 
/*     */     
/*     */     public GenericReparseBuffer() {}
/*     */ 
/*     */     
/*     */     public GenericReparseBuffer(Pointer param1Pointer) {
/* 266 */       super(param1Pointer);
/* 267 */       read();
/*     */     }
/*     */ 
/*     */     
/*     */     public GenericReparseBuffer(String param1String) {
/* 272 */       this.DataBuffer = param1String.getBytes();
/* 273 */       write();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"ReparseTag", "ReparseDataLength", "Reserved", "u"})
/*     */   public static class REPARSE_DATA_BUFFER
/*     */     extends Structure
/*     */   {
/*     */     public static class ByReference
/*     */       extends REPARSE_DATA_BUFFER
/*     */       implements Structure.ByReference
/*     */     {
/*     */       public ByReference() {}
/*     */       
/*     */       public ByReference(Pointer param2Pointer) {
/* 289 */         super(param2Pointer);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 296 */     public int ReparseTag = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 301 */     public short ReparseDataLength = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     public short Reserved = 0;
/*     */     
/*     */     public REPARSE_UNION u;
/*     */ 
/*     */     
/*     */     public static class REPARSE_UNION
/*     */       extends Union
/*     */     {
/*     */       public Ntifs.SymbolicLinkReparseBuffer symLinkReparseBuffer;
/*     */       public Ntifs.MountPointReparseBuffer mountPointReparseBuffer;
/*     */       
/*     */       public REPARSE_UNION(Pointer param2Pointer) {
/* 321 */         super(param2Pointer);
/*     */       }
/*     */       
/*     */       public Ntifs.GenericReparseBuffer genericReparseBuffer;
/*     */       
/*     */       public static class ByReference extends REPARSE_UNION implements Structure.ByReference {}
/*     */       
/*     */       public REPARSE_UNION() {}
/*     */     }
/*     */     
/*     */     public static int sizeOf() {
/* 332 */       return Native.getNativeSize(REPARSE_DATA_BUFFER.class, null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getSize() {
/* 339 */       return 8 + this.ReparseDataLength;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public REPARSE_DATA_BUFFER() {}
/*     */ 
/*     */     
/*     */     public REPARSE_DATA_BUFFER(int param1Int, short param1Short) {
/* 348 */       this.ReparseTag = param1Int;
/* 349 */       this.Reserved = param1Short;
/* 350 */       this.ReparseDataLength = 0;
/* 351 */       write();
/*     */     }
/*     */ 
/*     */     
/*     */     public REPARSE_DATA_BUFFER(int param1Int, short param1Short, Ntifs.SymbolicLinkReparseBuffer param1SymbolicLinkReparseBuffer) {
/* 356 */       this.ReparseTag = param1Int;
/* 357 */       this.Reserved = param1Short;
/* 358 */       this.ReparseDataLength = (short)param1SymbolicLinkReparseBuffer.size();
/* 359 */       this.u.setType(Ntifs.SymbolicLinkReparseBuffer.class);
/* 360 */       this.u.symLinkReparseBuffer = param1SymbolicLinkReparseBuffer;
/* 361 */       write();
/*     */     }
/*     */     
/*     */     public REPARSE_DATA_BUFFER(Pointer param1Pointer) {
/* 365 */       super(param1Pointer);
/* 366 */       read();
/*     */     }
/*     */ 
/*     */     
/*     */     public void read() {
/* 371 */       super.read();
/*     */       
/* 373 */       switch (this.ReparseTag) {
/*     */         default:
/* 375 */           this.u.setType(Ntifs.GenericReparseBuffer.class);
/*     */           break;
/*     */         case -1610612733:
/* 378 */           this.u.setType(Ntifs.MountPointReparseBuffer.class);
/*     */           break;
/*     */         case -1610612724:
/* 381 */           this.u.setType(Ntifs.SymbolicLinkReparseBuffer.class);
/*     */           break;
/*     */       } 
/* 384 */       this.u.read();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Ntifs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */