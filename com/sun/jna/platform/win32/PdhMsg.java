package com.sun.jna.platform.win32;

public interface PdhMsg {
  public static final int PDH_CSTATUS_VALID_DATA = 0;
  
  public static final int PDH_CSTATUS_NEW_DATA = 1;
  
  public static final int PDH_CSTATUS_NO_MACHINE = -2147481648;
  
  public static final int PDH_CSTATUS_NO_INSTANCE = -2147481647;
  
  public static final int PDH_MORE_DATA = -2147481646;
  
  public static final int PDH_CSTATUS_ITEM_NOT_VALIDATED = -2147481645;
  
  public static final int PDH_RETRY = -2147481644;
  
  public static final int PDH_NO_DATA = -2147481643;
  
  public static final int PDH_CALC_NEGATIVE_DENOMINATOR = -2147481642;
  
  public static final int PDH_CALC_NEGATIVE_TIMEBASE = -2147481641;
  
  public static final int PDH_CALC_NEGATIVE_VALUE = -2147481640;
  
  public static final int PDH_DIALOG_CANCELLED = -2147481639;
  
  public static final int PDH_END_OF_LOG_FILE = -2147481638;
  
  public static final int PDH_ASYNC_QUERY_TIMEOUT = -2147481637;
  
  public static final int PDH_CANNOT_SET_DEFAULT_REALTIME_DATASOURCE = -2147481636;
  
  public static final int PDH_CSTATUS_NO_OBJECT = -1073738824;
  
  public static final int PDH_CSTATUS_NO_COUNTER = -1073738823;
  
  public static final int PDH_CSTATUS_INVALID_DATA = -1073738822;
  
  public static final int PDH_MEMORY_ALLOCATION_FAILURE = -1073738821;
  
  public static final int PDH_INVALID_HANDLE = -1073738820;
  
  public static final int PDH_INVALID_ARGUMENT = -1073738819;
  
  public static final int PDH_FUNCTION_NOT_FOUND = -1073738818;
  
  public static final int PDH_CSTATUS_NO_COUNTERNAME = -1073738817;
  
  public static final int PDH_CSTATUS_BAD_COUNTERNAME = -1073738816;
  
  public static final int PDH_INVALID_BUFFER = -1073738815;
  
  public static final int PDH_INSUFFICIENT_BUFFER = -1073738814;
  
  public static final int PDH_CANNOT_CONNECT_MACHINE = -1073738813;
  
  public static final int PDH_INVALID_PATH = -1073738812;
  
  public static final int PDH_INVALID_INSTANCE = -1073738811;
  
  public static final int PDH_INVALID_DATA = -1073738810;
  
  public static final int PDH_NO_DIALOG_DATA = -1073738809;
  
  public static final int PDH_CANNOT_READ_NAME_STRINGS = -1073738808;
  
  public static final int PDH_LOG_FILE_CREATE_ERROR = -1073738807;
  
  public static final int PDH_LOG_FILE_OPEN_ERROR = -1073738806;
  
  public static final int PDH_LOG_TYPE_NOT_FOUND = -1073738805;
  
  public static final int PDH_NO_MORE_DATA = -1073738804;
  
  public static final int PDH_ENTRY_NOT_IN_LOG_FILE = -1073738803;
  
  public static final int PDH_DATA_SOURCE_IS_LOG_FILE = -1073738802;
  
  public static final int PDH_DATA_SOURCE_IS_REAL_TIME = -1073738801;
  
  public static final int PDH_UNABLE_READ_LOG_HEADER = -1073738800;
  
  public static final int PDH_FILE_NOT_FOUND = -1073738799;
  
  public static final int PDH_FILE_ALREADY_EXISTS = -1073738798;
  
  public static final int PDH_NOT_IMPLEMENTED = -1073738797;
  
  public static final int PDH_STRING_NOT_FOUND = -1073738796;
  
  public static final int PDH_UNABLE_MAP_NAME_FILES = -2147480619;
  
  public static final int PDH_UNKNOWN_LOG_FORMAT = -1073738794;
  
  public static final int PDH_UNKNOWN_LOGSVC_COMMAND = -1073738793;
  
  public static final int PDH_LOGSVC_QUERY_NOT_FOUND = -1073738792;
  
  public static final int PDH_LOGSVC_NOT_OPENED = -1073738791;
  
  public static final int PDH_WBEM_ERROR = -1073738790;
  
  public static final int PDH_ACCESS_DENIED = -1073738789;
  
  public static final int PDH_LOG_FILE_TOO_SMALL = -1073738788;
  
  public static final int PDH_INVALID_DATASOURCE = -1073738787;
  
  public static final int PDH_INVALID_SQLDB = -1073738786;
  
  public static final int PDH_NO_COUNTERS = -1073738785;
  
  public static final int PDH_SQL_ALLOC_FAILED = -1073738784;
  
  public static final int PDH_SQL_ALLOCCON_FAILED = -1073738783;
  
  public static final int PDH_SQL_EXEC_DIRECT_FAILED = -1073738782;
  
  public static final int PDH_SQL_FETCH_FAILED = -1073738781;
  
  public static final int PDH_SQL_ROWCOUNT_FAILED = -1073738780;
  
  public static final int PDH_SQL_CONNECT_FAILED = -1073738778;
  
  public static final int PDH_SQL_BIND_FAILED = -1073738777;
  
  public static final int PDH_CANNOT_CONNECT_WMI_SERVER = -1073738776;
  
  public static final int PDH_PLA_COLLECTION_ALREADY_RUNNING = -1073738775;
  
  public static final int PDH_PLA_ERROR_SCHEDULE_OVERLAP = -1073738774;
  
  public static final int PDH_PLA_COLLECTION_NOT_FOUND = -1073738773;
  
  public static final int PDH_PLA_ERROR_SCHEDULE_ELAPSED = -1073738772;
  
  public static final int PDH_PLA_ERROR_NOSTART = -1073738771;
  
  public static final int PDH_PLA_ERROR_ALREADY_EXISTS = -1073738770;
  
  public static final int PDH_PLA_ERROR_TYPE_MISMATCH = -1073738769;
  
  public static final int PDH_PLA_ERROR_FILEPATH = -1073738768;
  
  public static final int PDH_PLA_SERVICE_ERROR = -1073738767;
  
  public static final int PDH_PLA_VALIDATION_ERROR = -1073738766;
  
  public static final int PDH_PLA_VALIDATION_WARNING = -2147480589;
  
  public static final int PDH_PLA_ERROR_NAME_TOO_LONG = -1073738764;
  
  public static final int PDH_INVALID_SQL_LOG_FORMAT = -1073738763;
  
  public static final int PDH_COUNTER_ALREADY_IN_QUERY = -1073738762;
  
  public static final int PDH_BINARY_LOG_CORRUPT = -1073738761;
  
  public static final int PDH_LOG_SAMPLE_TOO_SMALL = -1073738760;
  
  public static final int PDH_OS_LATER_VERSION = -1073738759;
  
  public static final int PDH_OS_EARLIER_VERSION = -1073738758;
  
  public static final int PDH_INCORRECT_APPEND_TIME = -1073738757;
  
  public static final int PDH_UNMATCHED_APPEND_COUNTER = -1073738756;
  
  public static final int PDH_SQL_ALTER_DETAIL_FAILED = -1073738755;
  
  public static final int PDH_QUERY_PERF_DATA_TIMEOUT = -1073738754;
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\PdhMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */