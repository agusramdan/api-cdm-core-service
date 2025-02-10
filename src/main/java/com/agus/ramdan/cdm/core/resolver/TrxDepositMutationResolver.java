package com.agus.ramdan.cdm.core.resolver;

import com.agus.ramdan.cdm.core.dto.command.CreateTrxDepositCommandDTO;
import com.agus.ramdan.cdm.core.dto.command.TrxDepositResponseDTO;
import com.agus.ramdan.cdm.core.dto.command.UpdateTrxDepositCommandDTO;
import com.agus.ramdan.cdm.core.service.TrxDepositCommandService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrxDepositMutationResolver  implements GraphQLQueryResolver {
    private final TrxDepositCommandService service;
    @MutationMapping
    public TrxDepositResponseDTO createTrxDeposit(CreateTrxDepositCommandDTO input) {
        return service.createTrxDeposit(input);
    }

    @MutationMapping
    public TrxDepositResponseDTO updateTrxDeposit(UpdateTrxDepositCommandDTO input) {
        return service.updateTrxDeposit(input);
    }
}
