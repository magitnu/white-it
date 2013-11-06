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
	
	private static SessionLogic _sessionLogic;
	public static SessionLogic session() {
		if(_sessionLogic == null)
			_sessionLogic = new SessionLogic();
		return _sessionLogic;
	}
	
	private static UserLogic _userLogic;
	public static UserLogic user() {
		if(_userLogic == null)
			_userLogic = new UserLogic();
		return _userLogic;
	}
	
	private static ValidationLogic _validationLogic;
	public static ValidationLogic validation() {
		if(_validationLogic == null)
			_validationLogic = new ValidationLogic();
		return _validationLogic;
	}
	
}
