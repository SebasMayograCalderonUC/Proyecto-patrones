package com.cenfotec.grupo4.utils.encrypt;

import com.cenfotec.grupo4.interfaces.IEncryptManager;
import com.cenfotec.grupo4.utils.SavingType;

public class EncryptManagerFactory {
	public static IEncryptManager EncryptorFactory(SavingType type) {
		switch (type) {
		case Asymetric:
			return new EncryptManagerAsymetric();
		case Symetric:
			return new EncryptManagerSymetric();
		case MongoDB:
			return null;
		}
		return null;
	}
}
