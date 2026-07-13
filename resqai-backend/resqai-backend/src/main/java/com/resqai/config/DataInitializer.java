package com.resqai.config;

import com.resqai.entity.FirstAidGuide;
import com.resqai.repository.FirstAidGuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final FirstAidGuideRepository firstAidGuideRepository;

    @Override
    public void run(String... args) throws Exception {
        if (firstAidGuideRepository.count() == 0) {
            List<FirstAidGuide> defaultGuides = List.of(
                FirstAidGuide.builder()
                    .emergencyType("Snake Bite")
                    .symptoms("Two puncture wounds, swelling/redness, severe pain, nausea/vomiting, difficulty breathing.")
                    .firstAidSteps("• Keep the victim calm and still.\n• Immobilize the limb below heart level.\n• Do NOT cut the wound or suck the venom.\n• Remove tight clothing or jewelry.\n• Seek immediate medical attention.")
                    .build(),

                FirstAidGuide.builder()
                    .emergencyType("Burns")
                    .symptoms("Redness, pain, swelling, blistering, white/charred skin (third-degree).")
                    .firstAidSteps("• Run cool water over the burn for 20 minutes.\n• Do NOT use ice, toothpaste, butter, or oil.\n• Cover loosely with a clean, non-stick cloth/bandage.\n• Seek immediate medical help for severe/chemical burns.")
                    .build(),

                FirstAidGuide.builder()
                    .emergencyType("Heart Attack")
                    .symptoms("Chest pain/pressure/squeezing, pain spreading to arm/jaw/back, shortness of breath, sweating, lightheadedness.")
                    .firstAidSteps("• Call emergency services (ambulance) immediately.\n• Have the person sit and rest calmly.\n• Loosen tight clothing.\n• Give aspirin if they are not allergic.\n• Perform CPR if they lose consciousness.")
                    .build(),

                FirstAidGuide.builder()
                    .emergencyType("Heavy Bleeding")
                    .symptoms("Continuous flow of blood, pooling blood, symptoms of shock (pale skin, cold sweat, rapid breathing).")
                    .firstAidSteps("• Apply direct firm pressure with a clean cloth/bandage.\n• Elevate the wound above heart level if possible.\n• Do NOT remove embedded objects (stabilize them instead).\n• Keep applying pressure until help arrives.")
                    .build(),

                FirstAidGuide.builder()
                    .emergencyType("Fracture")
                    .symptoms("Intense pain, swelling/bruising, deformity, inability to move the limb, bone protruding (open fracture).")
                    .firstAidSteps("• Do NOT attempt to realign the bone.\n• Immobilize the injured area using a splint or sling.\n• Apply cold packs/ice to reduce swelling (wrapped in cloth).\n• Keep the person still and warm. Visit the nearest hospital.")
                    .build(),

                FirstAidGuide.builder()
                    .emergencyType("Choking")
                    .symptoms("Inability to speak/breathe/cough, clutching the throat, bluish skin/lips.")
                    .firstAidSteps("• Encourage coughing if they can cough.\n• If unable to breathe, perform abdominal thrusts (Heimlich maneuver).\n• Call emergency services immediately. Perform CPR if they become unconscious.")
                    .build()
            );

            firstAidGuideRepository.saveAll(defaultGuides);
            System.out.println("Default First Aid guides populated in the database.");
        }
    }
}
