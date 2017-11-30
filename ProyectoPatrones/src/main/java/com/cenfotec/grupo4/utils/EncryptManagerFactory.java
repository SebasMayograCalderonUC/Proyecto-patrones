package com.cenfotec.grupo4.utils;

import com.cenfotec.grupo4.interfaces.IEncryptManager;

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
