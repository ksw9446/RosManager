package path_finder_pkg;

import org.ros.internal.message.Message;

/**
 * Created by ailab on 17. 10. 12.
 */

public interface Service_messageRequest extends Message {
    String _Type="path_finder_pkg/Service_message";
    String _DEFINITION="string reqmsg\n";

    public void setReqmsg(String request);
    String getReqmsg();
}
