package neaos.marathon.client.model.v2;

import cloudnil.marathon.client.utils.ModelUtils;

public class UpgradeStrategy {
	private Double minimumHealthCapacity;
	private Double maximumOverCapacity;
	
	public UpgradeStrategy(){
		
	}
	public UpgradeStrategy(Double minimumHealthCapacity, Double maximumOverCapacity) {
		this.minimumHealthCapacity = minimumHealthCapacity;
		this.maximumOverCapacity = maximumOverCapacity;
	}
	
	public Double getMinimumHealthCapacity() {
		return minimumHealthCapacity;
	}
	public void setMinimumHealthCapacity(Double minimumHealthCapacity) {
		this.minimumHealthCapacity = minimumHealthCapacity;
	}
	public Double getMaximumOverCapacity() {
		return maximumOverCapacity;
	}
	public void setMaximumOverCapacity(Double maximumOverCapacity) {
		this.maximumOverCapacity = maximumOverCapacity;
	}
	
	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
