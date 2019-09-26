package DyAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Brand {
	public enum BrandFactory {
		IBENZ("Ibenz"), MUSICMAN("MusicMan"), FENDER("Fender"), DINGWALL("DingWall"), KILLER("Killer"), DEFAULT("");

		private String brandFactoryStr;

		private BrandFactory(String arg0) {
			this.brandFactoryStr = arg0;
		}

		@Override
		public String toString() {
			return brandFactoryStr;
		}

	}

	public BrandFactory brand() default BrandFactory.DEFAULT;
}
