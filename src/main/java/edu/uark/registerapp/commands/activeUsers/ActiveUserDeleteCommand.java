package edu.uark.registerapp.commands.activeUsers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.repositories.ActiveUserRepository;

@Service
public class ActiveUserDeleteCommand{
    // Properties
    private String sessionKey;
    public String getSessionKey() {
        return this.sessionKey;
    }
    public ActiveUserDeleteCommand setSessionKey(final String sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }
    
	@Transactional
	@Override
	public void execute() {
		final Optional<ActiveUserEntity> activeUserEntity =
			this.activeUserRepository.findBySessionKey(this.sessionKey);

		if (activeUserEntity.isPresent()) {
			this.activeUserRepository.delete(activeUserEntity.get());
		}
	}
}