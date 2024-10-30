/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Rasapi32Util
/*     */ {
/*     */   private static final int RASP_PppIp = 32801;
/*  47 */   private static Object phoneBookMutex = new Object();
/*     */   
/*  49 */   public static final Map CONNECTION_STATE_TEXT = new HashMap<Object, Object>();
/*     */   
/*     */   static {
/*  52 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(0), "Opening the port...");
/*  53 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(1), "Port has been opened successfully");
/*  54 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(2), "Connecting to the device...");
/*  55 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(3), "The device has connected successfully.");
/*  56 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(4), "All devices in the device chain have successfully connected.");
/*  57 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(5), "Verifying the user name and password...");
/*  58 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(6), "An authentication event has occurred.");
/*  59 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(7), "Requested another validation attempt with a new user.");
/*  60 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(8), "Server has requested a callback number.");
/*  61 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(9), "The client has requested to change the password");
/*  62 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(10), "Registering your computer on the network...");
/*  63 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(11), "The link-speed calculation phase is starting...");
/*  64 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(12), "An authentication request is being acknowledged.");
/*  65 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(13), "Reauthentication (after callback) is starting.");
/*  66 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(14), "The client has successfully completed authentication.");
/*  67 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(15), "The line is about to disconnect for callback.");
/*  68 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(16), "Delaying to give the modem time to reset for callback.");
/*  69 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(17), "Waiting for an incoming call from server.");
/*  70 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(18), "Projection result information is available.");
/*  71 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(19), "User authentication is being initiated or retried.");
/*  72 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(20), "Client has been called back and is about to resume authentication.");
/*  73 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(21), "Logging on to the network...");
/*  74 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(22), "Subentry has been connected");
/*  75 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(23), "Subentry has been disconnected");
/*  76 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(4096), "Terminal state supported by RASPHONE.EXE.");
/*  77 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(4097), "Retry authentication state supported by RASPHONE.EXE.");
/*  78 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(4098), "Callback state supported by RASPHONE.EXE.");
/*  79 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(4099), "Change password state supported by RASPHONE.EXE.");
/*  80 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(4100), "Displaying authentication UI");
/*  81 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(8192), "Connected to remote server successfully");
/*  82 */     CONNECTION_STATE_TEXT.put(Integer.valueOf(8193), "Disconnected");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Ras32Exception
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     private final int code;
/*     */ 
/*     */ 
/*     */     
/*     */     public int getCode() {
/* 100 */       return this.code;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Ras32Exception(int param1Int) {
/* 109 */       super(Rasapi32Util.getRasErrorString(param1Int));
/* 110 */       this.code = param1Int;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getRasErrorString(int paramInt) {
/* 120 */     char[] arrayOfChar = new char[1024];
/* 121 */     int i = Rasapi32.INSTANCE.RasGetErrorString(paramInt, arrayOfChar, arrayOfChar.length);
/* 122 */     if (i != 0) return "Unknown error " + paramInt; 
/* 123 */     byte b = 0;
/* 124 */     for (; b < arrayOfChar.length && arrayOfChar[b] != '\000'; b++);
/* 125 */     return new String(arrayOfChar, 0, b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getRasConnectionStatusText(int paramInt) {
/* 134 */     if (!CONNECTION_STATE_TEXT.containsKey(Integer.valueOf(paramInt))) return Integer.toString(paramInt); 
/* 135 */     return (String)CONNECTION_STATE_TEXT.get(Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WinNT.HANDLE getRasConnection(String paramString) throws Ras32Exception {
/* 146 */     IntByReference intByReference1 = new IntByReference(0);
/* 147 */     IntByReference intByReference2 = new IntByReference();
/* 148 */     int i = Rasapi32.INSTANCE.RasEnumConnections(null, intByReference1, intByReference2);
/* 149 */     if (i != 0 && i != 603) throw new Ras32Exception(i); 
/* 150 */     if (intByReference1.getValue() == 0) return null;
/*     */ 
/*     */     
/* 153 */     WinRas.RASCONN[] arrayOfRASCONN = new WinRas.RASCONN[intByReference2.getValue()]; byte b;
/* 154 */     for (b = 0; b < intByReference2.getValue(); ) { arrayOfRASCONN[b] = new WinRas.RASCONN(); b++; }
/* 155 */      intByReference1 = new IntByReference((arrayOfRASCONN[0]).dwSize * intByReference2.getValue());
/* 156 */     i = Rasapi32.INSTANCE.RasEnumConnections(arrayOfRASCONN, intByReference1, intByReference2);
/* 157 */     if (i != 0) throw new Ras32Exception(i);
/*     */ 
/*     */     
/* 160 */     for (b = 0; b < intByReference2.getValue(); b++) {
/* 161 */       if ((new String((arrayOfRASCONN[b]).szEntryName)).equals(paramString)) return (arrayOfRASCONN[b]).hrasconn; 
/*     */     } 
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hangupRasConnection(String paramString) throws Ras32Exception {
/* 172 */     WinNT.HANDLE hANDLE = getRasConnection(paramString);
/* 173 */     if (hANDLE == null)
/* 174 */       return;  int i = Rasapi32.INSTANCE.RasHangUp(hANDLE);
/* 175 */     if (i != 0) throw new Ras32Exception(i);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hangupRasConnection(WinNT.HANDLE paramHANDLE) throws Ras32Exception {
/* 184 */     if (paramHANDLE == null)
/* 185 */       return;  int i = Rasapi32.INSTANCE.RasHangUp(paramHANDLE);
/* 186 */     if (i != 0) throw new Ras32Exception(i);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WinRas.RASPPPIP getIPProjection(WinNT.HANDLE paramHANDLE) throws Ras32Exception {
/* 196 */     WinRas.RASPPPIP rASPPPIP = new WinRas.RASPPPIP();
/* 197 */     IntByReference intByReference = new IntByReference(rASPPPIP.size());
/* 198 */     rASPPPIP.write();
/* 199 */     int i = Rasapi32.INSTANCE.RasGetProjectionInfo(paramHANDLE, 32801, rASPPPIP.getPointer(), intByReference);
/* 200 */     if (i != 0) throw new Ras32Exception(i); 
/* 201 */     rASPPPIP.read();
/* 202 */     return rASPPPIP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WinRas.RASENTRY.ByReference getPhoneBookEntry(String paramString) throws Ras32Exception {
/* 212 */     synchronized (phoneBookMutex) {
/* 213 */       WinRas.RASENTRY.ByReference byReference = new WinRas.RASENTRY.ByReference();
/* 214 */       IntByReference intByReference = new IntByReference(byReference.size());
/* 215 */       int i = Rasapi32.INSTANCE.RasGetEntryProperties(null, paramString, byReference, intByReference, null, null);
/* 216 */       if (i != 0) throw new Ras32Exception(i); 
/* 217 */       return byReference;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setPhoneBookEntry(String paramString, WinRas.RASENTRY.ByReference paramByReference) throws Ras32Exception {
/* 228 */     synchronized (phoneBookMutex) {
/* 229 */       int i = Rasapi32.INSTANCE.RasSetEntryProperties(null, paramString, paramByReference, paramByReference.size(), null, 0);
/* 230 */       if (i != 0) throw new Ras32Exception(i);
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WinRas.RASDIALPARAMS getPhoneBookDialingParams(String paramString) throws Ras32Exception {
/* 241 */     synchronized (phoneBookMutex) {
/* 242 */       WinRas.RASDIALPARAMS.ByReference byReference = new WinRas.RASDIALPARAMS.ByReference();
/* 243 */       System.arraycopy(byReference.szEntryName, 0, paramString.toCharArray(), 0, paramString.length());
/* 244 */       WinDef.BOOLByReference bOOLByReference = new WinDef.BOOLByReference();
/* 245 */       int i = Rasapi32.INSTANCE.RasGetEntryDialParams(null, byReference, bOOLByReference);
/* 246 */       if (i != 0) throw new Ras32Exception(i); 
/* 247 */       return byReference;
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
/*     */   public static WinNT.HANDLE dialEntry(String paramString) throws Ras32Exception {
/* 259 */     WinRas.RASCREDENTIALS.ByReference byReference = new WinRas.RASCREDENTIALS.ByReference();
/* 260 */     synchronized (phoneBookMutex) {
/* 261 */       byReference.dwMask = 7;
/* 262 */       int j = Rasapi32.INSTANCE.RasGetCredentials(null, paramString, byReference);
/* 263 */       if (j != 0) throw new Ras32Exception(j);
/*     */     
/*     */     } 
/*     */     
/* 267 */     WinRas.RASDIALPARAMS.ByReference byReference1 = new WinRas.RASDIALPARAMS.ByReference();
/* 268 */     System.arraycopy(paramString.toCharArray(), 0, byReference1.szEntryName, 0, paramString.length());
/* 269 */     System.arraycopy(byReference.szUserName, 0, byReference1.szUserName, 0, byReference.szUserName.length);
/* 270 */     System.arraycopy(byReference.szPassword, 0, byReference1.szPassword, 0, byReference.szPassword.length);
/* 271 */     System.arraycopy(byReference.szDomain, 0, byReference1.szDomain, 0, byReference.szDomain.length);
/*     */ 
/*     */     
/* 274 */     WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/* 275 */     int i = Rasapi32.INSTANCE.RasDial(null, null, byReference1, 0, null, hANDLEByReference);
/* 276 */     if (i != 0) {
/* 277 */       if (hANDLEByReference.getValue() != null) Rasapi32.INSTANCE.RasHangUp(hANDLEByReference.getValue()); 
/* 278 */       throw new Ras32Exception(i);
/*     */     } 
/* 280 */     return hANDLEByReference.getValue();
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
/*     */   public static WinNT.HANDLE dialEntry(String paramString, WinRas.RasDialFunc2 paramRasDialFunc2) throws Ras32Exception {
/* 292 */     WinRas.RASCREDENTIALS.ByReference byReference = new WinRas.RASCREDENTIALS.ByReference();
/* 293 */     synchronized (phoneBookMutex) {
/* 294 */       byReference.dwMask = 7;
/* 295 */       int j = Rasapi32.INSTANCE.RasGetCredentials(null, paramString, byReference);
/* 296 */       if (j != 0) throw new Ras32Exception(j);
/*     */     
/*     */     } 
/*     */     
/* 300 */     WinRas.RASDIALPARAMS.ByReference byReference1 = new WinRas.RASDIALPARAMS.ByReference();
/* 301 */     System.arraycopy(paramString.toCharArray(), 0, byReference1.szEntryName, 0, paramString.length());
/* 302 */     System.arraycopy(byReference.szUserName, 0, byReference1.szUserName, 0, byReference.szUserName.length);
/* 303 */     System.arraycopy(byReference.szPassword, 0, byReference1.szPassword, 0, byReference.szPassword.length);
/* 304 */     System.arraycopy(byReference.szDomain, 0, byReference1.szDomain, 0, byReference.szDomain.length);
/*     */ 
/*     */     
/* 307 */     WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/* 308 */     int i = Rasapi32.INSTANCE.RasDial(null, null, byReference1, 2, paramRasDialFunc2, hANDLEByReference);
/* 309 */     if (i != 0) {
/* 310 */       if (hANDLEByReference.getValue() != null) Rasapi32.INSTANCE.RasHangUp(hANDLEByReference.getValue()); 
/* 311 */       throw new Ras32Exception(i);
/*     */     } 
/* 313 */     return hANDLEByReference.getValue();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Rasapi32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */