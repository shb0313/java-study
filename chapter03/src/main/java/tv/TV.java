package tv;

public class TV {
	private int channel;      //1~255
	private int volume;       //0~100
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	
	public void power(boolean on) {
		this.power = on;
	}
	
	public void channel(int channel) {
		if(channel < 1) {
			this.channel = 255+channel;
		}else if(channel >= 255){
			this.channel = channel-255;
		}else {
			this.channel = channel;
		}
	}
	
	public void channel(boolean up) {
		if(up) {
			if(channel == 255) {
				this.channel = 1;
			}else {
				this.channel++;
			}
		}else {
			if(channel == 1) {
				this.channel = 255;
			}else {
				this.channel--;
			}
		}
	}
	
	public void volume(int volume) {
		if(volume <= 0) {
			this.volume = 0;
		}else if(volume >= 100) {
			this.volume = 100;
		}else {
			this.volume = volume;
		}
		
	}
	
	public void volume(boolean up) {
		if(up) {
			if(this.volume < 100) {
				this.volume++;
			}
		}else {
			if(this.volume > 0) {
				this.volume--;
			}			
		}
	}
	
	public int getChannel() {
		return channel;
	}
	public int getVolume() {
		return volume;
	}
	public boolean getPower() {
		return power;
	}
	
	public void status() {
		System.out.println("TV[power=" + (power ? "on" : "off") + "," + "channel=" + channel + "," + "volume=" + volume + "]");
	}
}
