package com.android.ceehack.trust.data;

/**
 * Created by Primosz on 15.03.14.
 */
public class Politic {

	@com.google.gson.annotations.SerializedName("name")
	private String name;

	@com.google.gson.annotations.SerializedName("surname")
	private boolean surname;

	@com.google.gson.annotations.SerializedName("id")
	private String mId;
	
	private Region region;

	public Politic() {

	}
	
	public Politic(String name, String surname) {
		this.setId(surname);
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return name + " " + surname;
	}

	/**
	 * Returns the politic id
	 */
	public String getId() {
		return mId;
	}

	/**
	 * Sets the politic id
	 * 
	 * @param id
	 *            id to set
	 */
	public final void setId(String id) {
		mId = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mId == null) ? 0 : mId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Politic))
			return false;
		Politic other = (Politic) obj;
		if (mId == null) {
			if (other.mId != null)
				return false;
		} else if (!mId.equals(other.mId))
			return false;
		return true;
	}

}
