package de.moscon.etl.beans.enums;

public enum Gender {

	MALE('m'),
	FEMALE('w'),
	DIVERS('d');

	private Character oneLetterShortcut;

	Gender(Character oneLetterShortcut) {
		this.oneLetterShortcut = oneLetterShortcut;
	}

	public static Gender fromOneLetter(String oneLetter) {
		Gender[] values = Gender.values();
		for (Gender value : values) {
			if (value.oneLetterShortcut == oneLetter.toCharArray()[0]) {
				return value;
			}
		}
		return MALE;    // FALLBACK
	}

}
