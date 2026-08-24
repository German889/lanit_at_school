#language:ru
@helpdesk @api
Функционал: Helpdesk API - Создание тикета
  Сценарий: Создание тикета с высоким приоритетом

    # Шаг 1. Безопасно подтягиваем credentials из configuration.properties
    * подготовить учетные данные для авторизации

    # Шаг 2. Авторизация и получение токена
    * создать запрос
      | method | path       | body       |
      | POST   | /api/login | login.json |
    * добавить header
      | Content-Type | application/json |
    * отправить запрос
    * статус код 200
    * извлечь данные
      | auth_token | $.token |
    * сравнить значения
      | ${auth_token} | != | null |

    # Шаг 3. Генерация уникального заголовка тикета
    * сгенерировать переменные
      | ticketTitle | Test Ticket EEEE DDDD |

    # Шаг 4. Создание тикета с высоким приоритетом
    * создать запрос
      | method | path         | body                          |
      | POST   | /api/tickets | createTicketHighPriority.json |
    * добавить header
      | Authorization | token ${auth_token} |
      | Content-Type  | application/json    |
    * отправить запрос
    * статус код 201

    # Шаг 5. Проверка созданного тикета
    * извлечь данные
      | ticketId   | $.id       |
      | priority   | $.priority |
      | title      | $.title    |
      | status     | $.status   |

    * сравнить значения
      | ${ticketId} | != | null |
      | ${priority} | == | 1    |
      | ${title}    | == | ${ticketTitle} |

    # Шаг 6. Дополнительная проверка через GET запрос
    * создать запрос
      | method | path                     |
      | GET    | /api/tickets/${ticketId} |
    * добавить header
      | Authorization | token ${auth_token} |
    * отправить запрос
    * статус код 200
    * извлечь данные
      | retrievedPriority | $.priority |
    * сравнить значения
      | ${retrievedPriority} | == | 1 |