#ifndef COMMAND_H
#define COMMAND_H

#include "CrystalEngine/Tool/Object.h"

namespace CrystalEngine
{

class Command : public Object
{
    std::string command;
    std::string *args;
    int size;
public:
    OBJECT(Command)

    Command(std::string _command);

    Command(std::string _command, std::initializer_list<std::string> _args);
    
    Command(Command& _command);

    ~Command();

    int getSize();

    std::string getCommand();

    std::string at(int _index);

    std::string operator[](int _index);

    void operator=(Command& _command);

    std::string toString();
};
} // namespace CrystalEngine
#endif