package ch.hsr.intte.whiteit.businesslogic;

public abstract class Logic {
	private static EntityLogic _entityLogic;
	public static EntityLogic entity() {
		if(_entityLogic == null)
			_entityLogic = new EntityLogic();
		return _entityLogic;
	}
	
	private static EntryLogic _entryLogic;
	public static EntryLogic entry() {
		if(_entryLogic == null)
			_entryLogic = new EntryLogic();
		return _entryLogic;
	}
	private static UserLogic _userLogic;
	public static UserLogic user() {
		if(_userLogic == null)
			_userLogic = new UserLogic();
		return _userLogic;
	}	
	private static HelperLogic _helperLogic;
	public static HelperLogic helper() {
		if(_helperLogic == null)
			_helperLogic = new HelperLogic();
		return _helperLogic;
	}	
}
