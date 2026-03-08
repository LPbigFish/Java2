package lab;

public class Setting {

	private static Setting instance;

	private double gravity = 9.81;
	private int numberOfUfos = 3;
	private double ufoMinPercentageHeight = 0.3;
	private double ufoMinSpeed = 70;
	private double ufoMaxSpeed = 150;
	private double bulletMinSpeed = 30;
	private double bulletMaxSpeed = 300;

	private Setting() {

	}

	private Setting(double gravity, int numberOfUfos, double ufoMinPercentageHeight, double ufoMinSpeed, double ufoMaxSpeed, double bulletMinSpeed, double bulletMaxSpeed) {
		this.gravity = gravity;
		this.numberOfUfos = numberOfUfos;
		this.ufoMinPercentageHeight = ufoMinPercentageHeight;
		this.ufoMinSpeed = ufoMinSpeed;
		this.ufoMaxSpeed = ufoMaxSpeed;
		this.bulletMinSpeed = bulletMinSpeed;
		this.bulletMaxSpeed = bulletMaxSpeed;
	}

	public static void configure(Setting setting) {
		instance = setting;
	}

	public static Setting getInstance() {
		return instance;
	}

	public double getGravity() {
		return gravity;
	}

	public int getNumberOfUfos() {
		return numberOfUfos;
	}

	public double getUfoMinPercentageHeight() {
		return ufoMinPercentageHeight;
	}

	public double getUfoMinSpeed() {
		return ufoMinSpeed;
	}

	public double getUfoMaxSpeed() {
		return ufoMaxSpeed;
	}

	public double getBulletMinSpeed() {
		return bulletMinSpeed;
	}

	public double getBulletMaxSpeed() {
		return bulletMaxSpeed;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static Setting newHardcoreSetting() {
		return builder()
				.setUfoMinSpeed(200)
				.setUfoMaxSpeed(500)
				.setNumberOfUfos(30)
				.setBulletMinSpeed(200)
				.build();
	}

	public static class Builder {
		private double gravity = 9.81;
		private int numberOfUfos = 3;
		private double ufoMinPercentageHeight = 0.3;
		private double ufoMinSpeed = 70;
		private double ufoMaxSpeed = 150;
		private double bulletMinSpeed = 30;
		private double bulletMaxSpeed = 300;

		public Builder setGravity(double gravity) {
			this.gravity = gravity;
			return this;
		}

		public Builder setNumberOfUfos(int numberOfUfos) {
			this.numberOfUfos = numberOfUfos;
			return this;
		}

		public Builder setUfoMinPercentageHeight(double ufoMinPercentageHeight) {
			this.ufoMinPercentageHeight = ufoMinPercentageHeight;
			return this;
		}

		public Builder setUfoMinSpeed(double ufoMinSpeed) {
			this.ufoMinSpeed = ufoMinSpeed;
			return this;
		}

		public Builder setUfoMaxSpeed(double ufoMaxSpeed) {
			this.ufoMaxSpeed = ufoMaxSpeed;
			return this;
		}

		public Builder setBulletMinSpeed(double bulletMinSpeed) {
			this.bulletMinSpeed = bulletMinSpeed;
			return this;
		}

		public Builder setBulletMaxSpeed(double bulletMaxSpeed) {
			this.bulletMaxSpeed = bulletMaxSpeed;
			return this;
		}

		public Setting build() {
			return new Setting(gravity, numberOfUfos, ufoMinPercentageHeight, ufoMinSpeed, ufoMaxSpeed, bulletMinSpeed, bulletMaxSpeed);
		}
	}
}
