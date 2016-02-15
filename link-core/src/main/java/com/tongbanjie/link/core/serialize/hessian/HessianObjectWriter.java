package com.tongbanjie.link.core.serialize.hessian;

import com.caucho.hessian.io.Hessian2Output;
import com.tongbanjie.link.core.serialize.ObjectWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by sunyi on 15/9/22.
 */
public class HessianObjectWriter implements ObjectWriter {

	@Override
	public byte[] write(Object object) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Hessian2Output output = new Hessian2Output(baos);
		try {
			output.writeObject(object);
			output.flush();
			return baos.toByteArray();
		} finally {
			output.close();
		}
	}

}
